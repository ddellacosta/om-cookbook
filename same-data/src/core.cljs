(ns same-data.core
  (:import [goog events])
  (:require
   [om.core :as om :include-macros true]
   [om.dom :as dom :include-macros true]))

(enable-console-print!)

(defn item-comp
  [{pos :pos} owner]
  (om/component
   (dom/li #js {:classes "item"}
           (str "Item at position " pos))))

(defn sep-comp
  [{pos :pos} owner]
  (om/component
   (dom/li #js {:classes "sep"}
           (str "Separator at position " pos))))

(defn resize-widget
  [{:keys [items] :as data} owner]
  (reify
    om/IRenderState
    (render-state [_ state]
      (apply dom/ul #js {:classes "items"}
             (map
              #(case (:type %)
                 :item (om/build item-comp %)
                 :sep  (om/build sep-comp %))
              (sort-by :pos items))))))

(def app-data (atom {:items [{:type :item :pos 1} {:type :sep :pos 2}
                             {:type :item :pos 3} {:type :sep :pos 4}
                             {:type :item :pos 5} {:type :sep :pos 6}]}))

(om/root resize-widget app-data {:target (.getElementById js/document "root")})
