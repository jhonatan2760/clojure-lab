(ns clojure-lab.handler.handler
  (:require [compojure.core :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [clojure-lab.controller.flight :as controller.flight]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            ))

(defroutes app-routes
           (GET "/" [] "Hello, World!")
           (GET "/flights" [from to] {:status 200
                               :body (controller.flight/find-flights {:from from :to to})})
           (GET "/airport/panel"
                {:status 200
                 :body (controller.flight/all-flights)})
           )

(def app
  (-> app-routes
      (wrap-json-response)
      (wrap-json-body {:keywords? true})
      (wrap-defaults api-defaults)))