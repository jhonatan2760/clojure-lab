(ns clojure-lab.controller.aiport-panel
  (:require [clojure-lab.model.flight :as models.flight]
            [clojure-lab.model.flight]
            [clojure-lab.model.panel :as model.panel]
            [clojure-lab.wire.out.airport-panel :as wire.out.airport-panel]
            [clojure-lab.adapter.airport-panel :as  adapter.airport-panel]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [schema.core :as s])
  (:import (java.io PushbackReader)))

(def flights
  (with-open [r (io/reader (io/resource "data/flights.edn"))]
    (edn/read (PushbackReader. r))))

(s/defn all-flights [] :- [models.flight/Flight]
  flights)

(s/defn get-airport-panel :- wire.out.airport-panel/AirportPanel
  []
  (adapter.airport-panel/wire->out  {:id         (random-uuid)
                                     :airport    "GRU"
                                     :flights    flights
                                     :date-time  (.toString (java.time.Instant/now))
                                     :updated-at (.toString (java.time.Instant/now))}))