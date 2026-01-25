(ns clojure-lab.controller.flight
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [schema.core :as s]
            [clojure-lab.logic.flight :as logic.flight]
            [clojure-lab.model.flight :as models.flight])
  (:import (java.io PushbackReader)))

(def flights
  (with-open [r (io/reader (io/resource "data/flights.edn"))]
    (edn/read (PushbackReader. r))))

(s/defn all-flights  :- [models.flight/Flight]
  []
  flights)

(s/defn find-flights :- [models.flight/Flight]
  [flight :- models.flight/SearchFlight]
  (logic.flight/find-flights flight flights))
