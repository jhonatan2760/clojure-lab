(ns clojure-lab.controller.aiport-panel
  (:require [clojure-lab.model.flight :as models.flight]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [schema.core :as s]
            [clojure-lab.model.flight :as model.flight]
            [clojure-lab.model.panel :as model.panel])
  (:import (java.io PushbackReader)
           (java.time Instant)))

(def flights
  (with-open [r (io/reader (io/resource "data/flights.edn"))]
    (edn/read (PushbackReader. r))))

(s/defn all-flights [] :- [models.flight/Flight]
  flights)

(s/defn get-airport-panel :- model.panel/AirportPanel
  []
  {:id         (random-uuid)
   :airport    "GRU"
   :flights    flights
   :date-time  (.toString (java.time.Instant/now))
   :updated-at (.toString (java.time.Instant/now))})