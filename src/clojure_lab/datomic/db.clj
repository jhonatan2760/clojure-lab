(ns clojure-lab.datomic.db
  (:require [datomic.client.api :as d]))

(defonce client
         (d/client {:server-type :datomic-local
                    :system "dev"
                    :storage-dir :mem})) ;; ou caminho absoluto

(def db-name "dev-db")

(defonce _ (d/create-database client {:db-name db-name}))

(defn conn []
  (d/connect client {:db-name db-name}))

