(ns clojure-lab.handler.handler
  (:require [compojure.core :refer :all]
            [clojure-lab.adapter.flight :as adapter.flight]
            [clojure-lab.adapter.airport-panel :as adapter.airport-panel]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [clojure-lab.controller.flight :as controller.flight]
            [clojure-lab.controller.aiport-panel :as controller.aiport-panel]
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
              :body   (controller.aiport-panel/get-airport-panel)})

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