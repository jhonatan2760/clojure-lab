(ns clojure_lab.clojure_the_brave_and_true.strings_chapter)

; Strings represent text. The name comes from the ancient Phoenicians, who
;one day invented the alphabet after an accident involving yarn. Here are
;some examples of string literals:

(def name "Jhonatan")
(def name-concatenation (str "Name: - " name))
(def multiple-lines-strings "line 1 - long string content
\\ line 2 - long string content.")

;Method that generate name and surname based on input
(defn name-and-surname [name surname]
  (str name " " surname))
