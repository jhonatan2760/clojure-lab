(ns unit.flights-unit-test
  (:require [clojure.test :refer :all]
            [clojure-lab.logic.flight :as logic.flight]))

(def flight-data-fixture
  [{:id #uuid "f3e7b0e1-1234-4f91-8b16-1b3e9a8e2e33"
    :iata-code "AA123"
    :airport-departure :JFK
    :airport-destination :LAX
    :flight-date "2025-06-10"
    :available-seats 50}
   {:id #uuid "a1f0d2b2-5678-41e9-a29f-9c76e4c5b7a1"
    :iata-code "DL456"
    :airport-departure :LAX
    :airport-destination :GRU
    :flight-date "2025-06-11"
    :available-seats 75}])

(deftest validate-flights-filter
  (testing "Filtering flights from JFK to LAX"
    (let [result (logic.flight/find-flights {:from :JFK :to :LAX} flight-data-fixture)]
      (is (= 1 (count result)) "Should return exactly one matching flight")
      (is (= "AA123" (:iata-code (first result))) "The flight code should be AA123"))))
