(ns back-it-up.core
  (:import [goog events])
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   [om.core :as om :include-macros true]
   [sablono.core :as html :refer [html] :include-macros true]
   [cljs.core.async :as async :refer [>! <! put! chan]]))

(enable-console-print!)

(defn clicked!
  [child-msgs action]
  (fn [_]
    (put! child-msgs action)))

(defn child
  [app-data owner]
  (om/component
   (html
    [:div
     [:button {:onClick (clicked! (om/get-state owner :child-msgs) :inc)}
      "Click me to increment."]
     [:button {:onClick (clicked! (om/get-state owner :child-msgs) :dec)}
      "Click me to decrement."]])))

(defn parent
  [{clicked :clicked :as app-data} owner]
  (reify
    om/IInitState
    (init-state [_]
      {:has-been-updated? false
       :child-msgs        (chan)})

    om/IWillMount
    (will-mount [_]
      (go (while true
            (let [child-msg (<! (om/get-state owner :child-msgs))]
              (if-not (om/get-state owner :has-been-updated?)
                (om/set-state! owner :has-been-updated? true))
              (case child-msg
                :dec (om/transact! app-data :clicked dec)
                :inc (om/transact! app-data :clicked inc))))))

    om/IRenderState
    (render-state [_ {:keys [has-been-updated? child-msgs] :as state}]
      (html
       [:div
        [:div.has-been-updated (str "User has clicked one of these? " has-been-updated?)]
        [:div.clicker (str "Clicked " clicked " times.")
         (om/build child {} {:state {:child-msgs child-msgs}})]]))))

(def app-data {:clicked 0})

(om/root parent app-data {:target (.getElementById js/document "root")})
