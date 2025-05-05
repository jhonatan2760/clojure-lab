(ns clojure-lab.clojure-the-brave-and-true.regular-expressions)

(def console-name "I'd like to test the brand-new product \n it seems to be the best new generation product.")

(defn generate-product-name [name variation value]
  (clojure.string/replace name variation value))
