(ns clojure-lab.handler.handler
  (:require [compojure.core :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [clojure-lab.controller.flight :as controller.flight]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            ))

(defroutes app-routes
           (GET "/" [] "Hello, World!")
           (GET "/flights" [] (controller.flight/find-flights))
           )

(def app
  (-> app-routes
      (wrap-json-response)
      (wrap-json-body {:keywords? true})
      (wrap-defaults api-defaults)))