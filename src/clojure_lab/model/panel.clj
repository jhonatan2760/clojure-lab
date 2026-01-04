(ns clojure-lab.model.panel
  (:require [clojure-lab.model.flight :as model.flight]
            [schema.core :as s]))

(s/defschema AirportPanel {:id         s/Uuid
                           :airport    s/Str
                           :flights    [model.flight/Flight]
                           :date-time  s/Str
                           :updated-at s/Str})