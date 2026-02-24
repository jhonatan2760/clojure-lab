(ns clojure-lab.controller.aiport-panel
  (:require [clojure-lab.model.flight :as models.flight]
            [clojure-lab.model.flight]
            [clojure-lab.model.panel :as model.panel]
            [clojure-lab.adapter.airport-panel :as adapter.airport-panel]
            [clojure-lab.datomic.flight :as datomic.flight]
            [schema.core :as s])
  (:import (java.time Instant)))


(s/defn all-flights [airport] :- models.flight/Flight
  (datomic.flight/filter-flights-by-airport-datomic airport))

(s/defn filter-flights [airport]
  )

(s/defn get-airport-panel :- model.panel/AirportPanel
  []
  (adapter.airport-panel/wire->out {:id         (random-uuid)
                                     :airport    "GRU"
                                     :flights    (all-flights)
                                     :date-time  (.toString (Instant/now))
                                    :updated-at (.toString (Instant/now))}))