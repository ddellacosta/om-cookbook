(ns extend-cursor.core
  (:require
   [om.core :as om :include-macros true]
   [sablono.core :as html :refer [html] :include-macros true]))

(enable-console-print!)

(defprotocol CursorKeys
  (keys' [this]))

(extend-type om/MapCursor
  CursorKeys
  (keys' [this] (keys this)))

(extend-type om/IndexedCursor
  CursorKeys
  (keys' [this] (range 0 (count this)))) ; treating the index as a type of key here

(defn extend-cursor
  [{:keys [indexedcursor mapcursor]} owner]
  (reify
    om/IRenderState
    (render-state [_ state]
      (html
       [:table
        [:thead
         [:tr [:th "Cursor Type"] [:th "Cursor Value"] [:th "output of CursorKeys keys' fn"]]]
        [:tbody
         [:tr [:td "MapCursor"] [:td (pr-str mapcursor)] [:td (pr-str (keys' mapcursor))]]
         [:tr [:td "IndexedCursor"] [:td (pr-str indexedcursor)] [:td (pr-str (keys' indexedcursor))]]]]))))

(def cursor-data {:mapcursor {:foo "foo" :bar "bar" :baz "baz" :qux "qux"}
                  :indexedcursor ["foo" "bar" "baz" "qux"]})

(om/root extend-cursor cursor-data {:target (.getElementById js/document "root")})
