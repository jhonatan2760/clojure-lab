(ns clojure-lab.clojure-the-brave-and-true.loop-recursion)

;Loop - through numbers, counting until 10.

(loop [index 0]
  (if (< index 10)
    (do
      (println (str "Counting - " index))
      (recur (inc index)))
    "Done"))