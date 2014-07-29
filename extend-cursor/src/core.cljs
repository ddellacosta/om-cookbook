(ns extend-cursor.core
  (:require
   [om.core :as om :include-macros true]
   [sablono.core :as html :refer [html] :include-macros true]))

(enable-console-print!)

(defprotocol MapCursorSize (keyword-key-count [this]))

(extend-type om/MapCursor
  MapCursorSize
  (keyword-key-count [this] (count (filter keyword? (keys this)))))

(defn extend-cursor
  [data owner]
  (reify
    om/IRenderState
    (render-state [_ {:keys [selected-date] :as state}]
      (html
       [:div
        [:div "MapCursor data: " (pr-str data)]
        [:div "Keyword keys in MapCursor: " (keyword-key-count data)]]))))

(def cursor-data {:foo "foo" :bar "bar" "not-keyword" "hah, sneaky!"})

(om/root extend-cursor cursor-data {:target (.getElementById js/document "root")})
