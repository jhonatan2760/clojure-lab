(ns clojure-lab.model.flight
  (:require [schema.core :as s]))

(s/defschema Flight {:id s/Uuid
                     :iata-code s/Str
                     :airport-departure s/Str
                     :airport-destination (s/maybe s/Str)
                     :flight-date s/Str
                     :available-seats s/Int})

(s/defschema SearchFlight {:airport-departure s/Str
                          :airport-destination (s/maybe s/Str)})