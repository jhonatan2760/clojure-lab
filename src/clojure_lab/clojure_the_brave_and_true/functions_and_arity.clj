(ns clojure-lab.clojure-the-brave-and-true.functions-and-arity)

(defn sum-two-numbers [a b] (+ a b))

(defn no-params []
  (println "No params"))

(defn sum-multiple-numbers
  "This example shows how to use multi arity to sum multiple numbers"
  [& numbers]
  (reduce + numbers))

(defn call-chop-type
  "This example shows how to use overloading"
  ([name chop-type]
   (println (str "I " chop-type " chop " name "! Take that!")))
  ([name]
   (call-chop-type name "Judo")))

(defn return-the-first-element-of-a-collection
  [[first-thing]]
  first-thing)

(println (return-the-first-element-of-a-collection ["Dewey" "Silva" "Malcolm"]))

(defn print-names-selector
  [[first-name second-name third-name]]
  (println "First name: " first-name)
  (println "Second name: " second-name)
  (println "Third name: " third-name))

(defn gps-cordinates
  "This example shows how to use destructuring to get the values of a map"
  [{:keys [latitude longitude]}]
  (println (str "Latitude: " latitude))
  (println (str "Longitude: " longitude)))

;Example of an anonymous function
(#(* 3 %) 8)
;=> 24

;Example of an anonymous function which takes more than one argument
(#((str %1 " and " %2) "Cornbread" "Beans"))

;Example of anonymous function which takes a args
(#((str identity %&)) "Jhon" :pencil "Clojure" 1 2 3)

;Using taking to separate the first two elements of a collection
(def dalmatian-list ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])
(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)

;Use scope to limit the visibility of a variable

(def x 0)
(let [x 1]
  x)
;=> 1

;Using var in a new scope but using the amount
(let [x (inc x)]
  x)
;=> 1

(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians])
;=> ("Pongo" "Perdita" "Puppy 1" "Puppy 2")

(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Done")
    (recur (inc iteration))))



