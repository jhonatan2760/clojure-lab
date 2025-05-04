(ns clojure-lab.clojure-the-brave-and-true.high-order-function-test
  (:require [clojure.test :refer :all]
            [clojure-lab.clojure-the-brave-and-true.high-order-function :refer :all]))

(defn generate-person
       [nacionality travel-purpose]
       {:name "Jhonatan"
        :age 40
        :nacionality nacionality
        :passport-number "123456789"
        :travel-purpose travel-purpose})

(deftest validate-passport-test
  (testing "Passport validation"
    (is (= "Checking passport...\nWelcome Jhonatan! Your passport number is 123456789\n"
           (with-out-str
             (border-control (generate-person "Brazilian" "tourism") passport-control))))))