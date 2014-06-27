(ns resize-listener.core
  (:import [goog events])
  (:require
   [om.core :as om :include-macros true]
   [sablono.core :as html :refer [html] :include-macros true]))

(enable-console-print!)

(defn update-window-size!
  [owner]
  (om/update-state! owner #(assoc % :wh (.-innerHeight js/window) :ww (.-innerWidth js/window))))

(defn resize-widget
  [data owner]
  (reify
    om/IInitState
    (init-state [_]
      {:wh (.-innerHeight js/window)
       :ww (.-innerWidth js/window)})

    om/IWillMount
    (will-mount [_]
      (events/listen js/window goog.events.EventType.RESIZE #(update-window-size! owner)))

    om/IRenderState
    (render-state [_ {:keys [ww wh] :as state}]
      (html
       [:div
        [:p.height "Height is: " wh]
        [:p.width "Width is: " ww]]))))

(om/root resize-widget {} {:target (.getElementById js/document "root")})
