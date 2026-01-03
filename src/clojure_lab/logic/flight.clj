(ns clojure-lab.logic.flight
  (:require [clojure-lab.wire.in.flight :as wire.in]
            [clojure-lab.model.flight :as model.flight]
            [schema.core :as s]))

(s/defn find-flights :- [model.flight/Flight]
  "Find available flights through sent parameters"
  [flight :- wire.in/Flight
   flights :- [model.flight/Flight]]
  (let [criteria (into {} (filter (comp some? val) flight))]
    (filter
      (fn [flight]
        (every?
          (fn [[k v]] (= (get flight k) v))
          criteria))
      flights)))

