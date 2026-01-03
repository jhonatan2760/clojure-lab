(ns clojure-lab.logic.flight
  (:require [clojure-lab.wire.in.flight :as wire.in]
            [clojure-lab.model.flight :as model.flight]
            [schema.core :as s]))

(s/defn find-flights :- [model.flight/Flight]
  [flight  :- model.flight/SearchFlight
   flights :- [model.flight/Flight]]
  (filter
    (fn [f]
      (or
        (nil? (:airport-departure flight))
        (= (:airport-departure f)
           (:airport-departure flight))))
    flights))


