(ns clojure-lab.datomic.init-db
  (:require [clojure-lab.model.datomic.flight :as flight-schema]
            [clojure-lab.datomic.db :refer [conn]]
            [clojure.edn :as edn]
            [clojure.java.io :as io]
            [datomic.client.api :as d]
            [schema.core :as s])
  (:import (java.io PushbackReader)))

(s/defn seed-flights! []
  (println "Seeding flight data into the database...")
  (let [resource (io/resource "data/flights.edn")]
    (when-not resource
      (throw (ex-info "Could not find resource data/flights.edn (expected under resources/data/)"
                      {:resource "data/flights.edn"})))
    (let [flights
          (with-open [r (io/reader resource)]
            (edn/read (PushbackReader. r)))

          tx-data
          (mapv (fn [{:keys [id iata-code airport-departure airport-destination flight-date available-seats]}]
                  {:flight/id                  id
                   :flight/iata-code            iata-code
                   :flight/airport-departure    airport-departure
                   :flight/airport-destination  airport-destination
                   :flight/flight-date          flight-date
                   :flight/available-seats      available-seats})
                flights)]

      (println "Transacting" (count tx-data) "flights...")
      (d/transact (conn) {:tx-data tx-data}))))

(defn init-db! []
  (println "Starting database initialization...")
  (flight-schema/install!)
  (seed-flights!))