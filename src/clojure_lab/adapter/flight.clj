(ns clojure-lab.adapter.flight
  (:require [clojure-lab.model.flight :as model.flight]
            [clojure-lab.wire.in.flight :as wire.in.flight]
            [clojure-lab.wire.out.flight :as wire.out.flight]
            [schema.core :as s]))

(s/defn wire->in [flight :- wire.in.flight/Flight] :- model.flight/SearchFlight
  {:airport-departure (:from flight)
   :airport-destination (:to flight)})

(s/defn wire->out [flights :- [model.flight/Flight]]
  :- [wire.out.flight/Flight]
  (mapv
    (fn [f]
      (select-keys f
                   [:id
                    :iata-code
                    :airport-departure
                    :airport-destination
                    :flight-date
                    :available-seats]))
    flights))