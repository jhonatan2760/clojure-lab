(ns handler_test
  (:require [clojure.test :refer :all]
            [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojure-lab.handler.handler :refer :all]))

(deftest test-homepage
  (let [response (app (mock/request :get "/"))]
    (is (= 200 (:status response)))
    (is (= "Hello, World!" (:body response)))))