(ns clojure-lab.logic.flight
  (:require [clojure-lab.wire.in.flight :as wire.in]
            [clojure-lab.model.flight :as model.flight]
            [schema.core :as s]))

(s/defn find-flights :- [model.flight/Flight]
        "Find available flights through sent parameters"
        [flight :- wire.in/Flight
         flights-data :- [model.flight/Flight]]
        ;TODO - convert it to a model return, convert the receive parameter as well
        (->> flights-data
             (filter #(= (:airport-departure %) (keyword (:from flight))))))
