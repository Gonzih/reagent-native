(ns reagent-native.core
  (:require [reagent.core :as r :refer [atom]]
            [reagent-native.react :as react]))

(enable-console-print!)

(def global-state (r/atom 0))

(defn root []
  [react/view
   [react/image {:source {:uri "https://camo.githubusercontent.com/5cf1b2ffa81724d25576fa375ace5a97a260116c/687474703a2f2f692e696d6775722e636f6d2f5331344a7946442e706e67"}
                 :style {:width 306 :height 104}}]
   [react/text
    {:on-press #(swap! global-state inc)}
    (str "Hi from cljs! state is:" @global-state)]])

(.registerRunnable react/app-registry "ReagentNative"
                   (fn [params] (r/render [root] (.-rootTag params))))
