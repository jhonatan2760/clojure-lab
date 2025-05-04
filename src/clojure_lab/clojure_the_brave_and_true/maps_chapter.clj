(ns clojure-lab.clojure-the-brave-and-true.maps-chapter)

;Maps are similar to dictionaries or hashes in other languages. They’re a way
;of associating some value with some other value. The two kinds of maps in
;Clojure are hash maps and sorted maps. I’ll only cover the more basic hash
;maps. Let’s look at some examples of map literals. Here’s an empty map

(def name-last-name {:name "Dewey"
                     :last-name "Silva"})

;Example of nested names

(def person {:name {:first "Malcolm"
                    :sur-name "Da Silva"}})

;Notice that map values can be of any type—strings, numbers, maps,
;vectors, even functions. Clojure don’t care!
; Besides using map literals, you can use the hash-map function to create

(def created-hash-map (hash-map :name "Carl" :balance 2.40))

(def option-map {:team1 "Man. Untd" :team2 "Santos" :team3 "Real Madrid"})

(defn read-option-map [team]
  (get team "team unavailable"))
