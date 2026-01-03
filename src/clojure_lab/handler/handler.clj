(ns clojure-lab.handler.handler
  (:require [cheshire.core :as json]
            [compojure.core :refer :all]
            [clojure-lab.adapter.flight :as adapter.flight]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [clojure-lab.controller.flight :as controller.flight]
            [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
            ))

(defroutes app-routes
           (GET "/favicon.ico" [] {:status 204})
           ;Customer flight-information
           (GET "/flights" [from to]
             (let [search (adapter.flight/wire->in {:from from :to to})
                   result (or (controller.flight/find-flights search) [])]
               {:status 200
                :body   {:flights result}}))
           (GET "/airport/panel"
                []
             {:status 200
              :body   (controller.flight/all-flights)})

           ;Airline flights information
           (GET "/airport/check-in"
                []
             {:status 200
              :body   (controller.flight/all-flights)})
           )

(def app
  (-> app-routes
      (wrap-json-response)
      (wrap-json-body {:keywords? true})
      (wrap-defaults api-defaults)))