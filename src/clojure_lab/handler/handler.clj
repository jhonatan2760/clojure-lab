(ns clojure-lab.handler.handler
  (:require [compojure.core :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
           (GET "/" [] "Hello, World!"))

(def app
  (wrap-defaults app-routes site-defaults))