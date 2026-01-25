(ns clojure-lab.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [clojure-lab.handler.handler :refer [app]]
            [clojure-lab.datomic.init-db :as db-init])
  (:gen-class))

(defn -main
  "Execute airport routine..."
  [& args]
  (db-init/init-db!)
  (run-jetty app {:port 3000 :join? false}))