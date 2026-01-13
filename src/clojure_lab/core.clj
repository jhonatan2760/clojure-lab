(ns clojure-lab.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [clojure-lab.handler.handler :refer [app]])
  (:gen-class))

(defn -main
  "Execute airport routine..."
  [& args]
  (run-jetty app {:port 3000 :join? false}))