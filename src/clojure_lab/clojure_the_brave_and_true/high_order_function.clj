(ns clojure-lab.clojure-the-brave-and-true.high-order-function)

(defn passport-control
  [{:keys [name age nacionality passport-number travel-purpose]}]
  (if (and (= nacionality "Brazilian") (= travel-purpose "tourism"))
    (println (str "Welcome " name "! Your passport number is " passport-number))
    (println (str "Sorry " name ", you are not allowed to enter the country."))))

(defn border-control
  [person passport-control]
  (println "Checking passport...")
  (passport-control person))

(border-control {:name            "Jhonatan"
                 :age             25
                 :nacionality     "Brazilian"
                 :passport-number "123456789"
                 :travel-purpose  "tourism"}
                  passport-control)