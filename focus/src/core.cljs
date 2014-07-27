(ns focus.core
  (:require
   [om.core :as om :include-macros true]
   [sablono.core :as html :refer [html] :include-macros true]))

(enable-console-print!)

(defn focus-input!
  [e owner]
  (.focus (om/get-node owner "my-input"))
  (om/set-state! owner :force-rerender! true))

(defn focus
  [data owner]
  (reify
    om/IRenderState
    (render-state [_ {:keys [selected-date] :as state}]
      (html
       [:div
        [:input.my-input {:type "text" :ref "my-input"}]
        [:button {:onClick #(focus-input! % owner)} "Click me to focus!"]]))))

(om/root focus {} {:target (.getElementById js/document "root")})
