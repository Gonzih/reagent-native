(ns reagent-native.react
  (:require-macros [reagent-native.macro :refer [adapt-react-classes]])
  (:require [reagent.core]))

(set! js/React (js/require "react-native"))

(adapt-react-classes text
                     text-input
                     view
                     image)

(def app-registry (.-AppRegistry js/React))
