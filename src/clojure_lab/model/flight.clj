(ns clojure-lab.model.flight
  (:require [schema.core :as s]))

(def airports
  #{:JFK :LAX :GRU :CDG :NRT :DXB :SYD :FRA :SFO :MIA})


(s/defschema Flight {:id s/Uuid
                     :iata-code s/Str
                     :airport-departure (apply s/enum airports)
                     :airport-destination (apply s/enum airports)
                     :flight-date s/Str
                     :available-seats s/Int})

