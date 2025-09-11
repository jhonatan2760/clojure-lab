(ns clojure-lab.logic.flight
  (:require [clojure-lab.wire.in.flight :as wire.in]
            [clojure-lab.wire.out.flight :as wire.out]
            [schema.core :as s]))

(s/defn find-flights :- [wire.out/Flight]
        "Find available flights through sent parameters"
        [flight :- wire.in/Flight]
        ;TODO - convert it to a model return, convert the receive parameter as well
        (->> flights
             (filter #(= (:airport-departure %) (keyword (:from flight))))))
