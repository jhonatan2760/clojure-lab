(ns clojure-lab.adapter.airport-panel
  (:require [clojure-lab.model.panel :as model.panel]
            [schema.core :as s]
            [clojure-lab.wire.out.airport-panel :as out.airport-panel]))

(s/defn wire->out :- out.airport-panel/AirportPanel
  [panel :- model.panel/AirportPanel]
  (let [{:keys [id flights airport date-time updated-at]} panel]
    {:id id
     :flights flights
     :airport airport
     :date-time date-time
     :updated-at updated-at}))

