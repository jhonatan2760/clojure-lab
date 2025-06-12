(ns clojure-lab.controller.flight
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [schema.core :as s]
            [clojure-lab.wire.in.flight :as wire.in]
            [clojure-lab.wire.out.flight :as wire.out])
  (:import (java.io PushbackReader)))

(def flights
  (with-open [r (io/reader (io/resource "data/flights.edn"))]
    (edn/read (PushbackReader. r))))

(s/defn find-flights :- [wire.out/Flight]
  "Find available flights through sent parameters"
  [flight :- wire.in/Flight]
  ;todo - filter flight by the query-param input
  flights)