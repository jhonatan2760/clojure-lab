(ns clojure-lab.model.datomic.flight
  (:require [datomic.client.api :as d]
            [clojure-lab.datomic.db :refer [conn]]))

(def flight-datomic-schema
  [{:db/ident       :flight/id
    :db/valueType   :db.type/uuid
    :db/cardinality :db.cardinality/one
    :db/unique      :db.unique/identity}

   {:db/ident       :flight/iata-code
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one}

   {:db/ident       :flight/airport-departure
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one}

   {:db/ident       :flight/airport-destination
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one}

   {:db/ident       :flight/flight-date
    :db/valueType   :db.type/string
    :db/cardinality :db.cardinality/one}

   {:db/ident       :flight/available-seats
    :db/valueType   :db.type/long
    :db/cardinality :db.cardinality/one}])

(defn install! []
  (d/transact (conn)
              {:tx-data flight-datomic-schema}))