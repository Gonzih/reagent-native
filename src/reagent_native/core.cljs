(ns reagent-native.core
  (:require [reagent.core :as r :refer [atom]]
            [reagent.impl.component :as rc]
            [reagent.impl.template :as rt]))

(set! js/React (js/require "react-native"))

(def app-registry (.-AppRegistry js/React))
(def view (r/adapt-react-class (.-View js/React)))
(def text (r/adapt-react-class (.-Text js/React)))

(enable-console-print!)

(def global-state (r/atom 0))

(defn root []
  [view
   [text (str "Hi from cljs!" @global-state)]])

(.registerComponent (.-AppRegistry js/React)
                    "ReagentNative"
                    (fn [] (rt/as-class root)))
