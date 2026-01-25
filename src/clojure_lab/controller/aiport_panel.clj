(ns clojure-lab.controller.aiport-panel
  (:require [clojure-lab.model.flight :as models.flight]
            [clojure-lab.model.flight]
            [clojure-lab.model.panel :as model.panel]
            [clojure-lab.adapter.airport-panel :as adapter.airport-panel]
            [clojure-lab.datomic.flight :as datomic.flight]
            [schema.core :as s])
  (:import (java.time Instant)))


(s/defn all-flights [] :- [models.flight/Flight]
  (println (datomic.flight/all-flights-datomic))
  [])

(s/defn get-airport-panel :- model.panel/AirportPanel
  []
  (adapter.airport-panel/wire->out {:id         (random-uuid)
                                     :airport    "GRU"
                                     :flights    (all-flights)
                                     :date-time  (.toString (Instant/now))
                                    :updated-at (.toString (Instant/now))}))