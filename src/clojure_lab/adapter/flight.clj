(ns clojure-lab.adapter.flight
  (:require [clojure-lab.model.flight :as model.flight]
            [clojure-lab.wire.in.flight :as wire.in.flight]
            [schema.core :as s]))

(s/defn wire->in [flight :- wire.in.flight/Flight] :- model.flight/SearchFlight
  {:airport-departure (:from flight)
   :airport-destination (:to flight)})
