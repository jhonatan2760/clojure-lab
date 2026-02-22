(ns clojure-lab.adapter.flight
  (:require [clojure-lab.model.flight :as model.flight]
            [clojure-lab.wire.in.flight :as wire.in.flight]
            [clojure-lab.wire.out.flight :as wire.out.flight]
            [schema.core :as s]))

(s/defn wire-in->internal :- model.flight/SearchFlight
  [flight :- wire.in.flight/Flight]
  {:airport-departure (:from flight)
   :airport-destination (:to flight)})

(s/defn internal->wire-out :- [wire.out.flight/Flight]
  [flights :- [model.flight/Flight]]
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