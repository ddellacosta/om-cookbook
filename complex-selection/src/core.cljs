(ns complex-selection.core
  (:require-macros
   [cljs.core.async.macros :refer [go]])
  (:require
   [om.core :as om :include-macros true]
   [sablono.core :as html :refer [html] :include-macros true]
   [cljs.core.async :as async :refer [>! <! put! chan]]))

(enable-console-print!)

(defn element
  [element owner {:keys [select-el-chan]}]
  (reify
    om/IRenderState
    (render-state [_ {:keys [selected]}]
      (html
       [:div.element
        {:class   (if (= selected element) "selected")
         :onClick #(put! select-el-chan element)}
        (str "Element " element)]))))

(defn elements
  [{:keys [elements key] :as data} owner]
  (reify
    om/IInitState
    (init-state [_]
      {:select-el-chan (chan)
       :selected nil})

    om/IWillMount
    (will-mount [_]
      (let [{:keys [select-el-chan]} (om/get-state owner)]
        (go (while true
              (let [selection (<! select-el-chan)]
                (om/set-state! owner :selected selection))))))

    om/IRenderState
    (render-state [_ {:keys [selected select-el-chan] :as state}]
      (html
       [:div.elements
        {:id (str "elements-" key)}
        [:h3 (str "Elements Set " key)]
        [:p (if selected (str "Currently selected element is " selected ".") "None selected.")]
        (om/build-all element elements {:state {:selected selected}
                                        :opts  {:select-el-chan select-el-chan}})]))))

(defn complex-selection
  [element-data owner]
  (reify
    om/IRenderState
    (render-state [_ state]
      (html
       [:div.elements-wrapper (om/build-all elements element-data {:key :key})]))))

(def app-data [{:key 1 :elements [1 2 3]}
               {:key 2 :elements [4 5 6]}])

(om/root complex-selection app-data {:target (.getElementById js/document "root")})
