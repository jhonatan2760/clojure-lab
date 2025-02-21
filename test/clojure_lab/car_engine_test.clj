(ns clojure-lab.car-engine-test
  (:require [clojure.test :refer :all]
            [clojure-lab.garage.logic.engine-logic :as logic]))

(def car_pulse_abarth {:model "Pulse Abarth" :engine "GSE-T270" :fuel-level 100
                       :turbo-pressure 0.0})

(deftest test-car-controll-flow
  (testing "When requested to fill gas and the gas level is less than the limit, SHOULD
   fill gas amount."
    (println (str "Fuel level: " (get car_pulse_abarth :fuel-level)))
    (is (= 250 (logic/insert-more-gas! (get car_pulse_abarth :fuel-level) 150))))

  (testing "When requested to fill gas and the gas level is more than the limite, SHOULDN'T]
  fill the car gas"
    (is (= nil (logic/insert-more-gas! (get car_pulse_abarth :fuel-level) 350)))))