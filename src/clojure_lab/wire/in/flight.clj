(ns clojure-lab.wire.in.flight
  (:require [schema.core :as s]))

(def flight-skeleton {:from s/Str
                      :to   (s/maybe s/Str)})

(s/defschema Flight flight-skeleton)