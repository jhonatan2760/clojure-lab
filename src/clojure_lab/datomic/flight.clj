(ns clojure-lab.datomic.flight
  (:require [datomic.client.api :as d]
            [clojure-lab.datomic.db :refer [conn]]))

(defn all-flights-datomic []
  (let [db (d/db (conn))]
    (->> (d/q '[:find (pull ?e [:flight/id
                                :flight/iata-code
                                :flight/airport-departure
                                :flight/airport-destination
                                :flight/flight-date
                                :flight/available-seats])
                :where
                [?e :flight/id ?id]]
              db)
         (mapv first))))