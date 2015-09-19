(ns reagent-native.core
  (:require [reagent.core :as r :refer [atom]]
            [reagent.impl.template :as rt]
            [reagent-native.react :as react]))

(enable-console-print!)

(def global-state (atom 0))

(def repl-history (atom []))

(defn input-cmp []
  (let [local-input (atom nil)]
    (fn []
      [react/text-input
       {:on-submit-editing #(do (swap! repl-history conj @local-input)
                                (reset! local-input nil))
        :on-change-text #(do (reset! local-input %)
                             (r/flush))
        :value @local-input}])))

(defn root []
  [react/view
   [react/view {:style {:alignItems "center"}}
    [react/image {:source {:uri "https://raw.githubusercontent.com/cljsinfo/logo.cljs/master/cljs-white.png"}
                  :style {:width 50 :height 50}}]]
   [react/text
    {:on-press #(swap! global-state inc)}
    (str "Hi from cljs! state is:" @global-state)]
   [react/text (str @repl-history)]
   [input-cmp]])

(.registerRunnable react/app-registry "ReagentNative"
                   (fn [params] (r/render [root] (.-rootTag params))))
