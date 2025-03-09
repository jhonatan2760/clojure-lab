(ns clojure-lab.clojure-the-brave-and-true.strings-chapter-test
  (:require [clojure.test :refer :all]
            [clojure_lab.clojure_the_brave_and_true.strings_chapter :as string-test]))

(deftest generate-name-and-surname-test
  (testing "Should generate name and surname when it's informed"
    (is (= "Jhonatan Ferdnand" (string-test/name-and-surname "Jhonatan" "Ferdnand"))))

  (testing "Should validate if the nome isn't scrambled"
    (is (not= "Ferdnand Jhonatan" (string-test/name-and-surname "Jhonatan" "Ferdnand")))))
