(ns clojure-lab.wire.out.airport-panel
  (:require [clojure-lab.model.flight :as model.flight]
            [schema.core :as s]))

(s/defschema AirportPanel {:id         s/Uuid
                           :airport    s/Str
                           :date-time  s/Str
                           :flights    [model.flight/Flight] ;todo return the flight wire.out
                           :updated-at s/Str})