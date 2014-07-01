(ns datetimepicker.core
  (:import
   [goog events]
   goog.i18n.DateTimeParse
   goog.i18n.DateTimeFormat
   [goog.ui InputDatePicker])
  (:require
   [om.core :as om :include-macros true]
   [sablono.core :as html :refer [html] :include-macros true]))

(enable-console-print!)

(def datetimepicker (atom nil))

(defn datetime-event
  [owner]
  (fn [e]
    (om/set-state! owner :selected-date (.-date e))))

(def months
  {0 "January"
   1 "February"
   2 "March"
   3 "April"
   4 "May"
   5 "June"
   6 "July"
   7 "August"
   8 "September"
   9 "October"
   10 "November"
   11 "December"})

(defn format-date
  [date]
  (str (get months (.getMonth date)) " " (.getDate date) ", " (.getFullYear date)))

(defn datetimepicker-component
  [data owner]
  (reify
    om/IInitState
    (init-state [_]
      {:selected-date nil})

    om/IWillMount
    (will-mount [_]
      (let [pattern "MM'/'dd'/'yyyy"
            formatter (goog.i18n.DateTimeFormat. pattern)
            parser    (goog.i18n.DateTimeParse. pattern)]
        (reset! datetimepicker (InputDatePicker. formatter parser))
        (events/listen @datetimepicker goog.ui.DatePicker.Events.CHANGE (datetime-event owner))))

    om/IDidMount
    (did-mount [_]
      (let [dtp-el (.getElementById js/document "datetimepicker")]
        (.decorate @datetimepicker dtp-el)))

    om/IWillUnmount
    (will-unmount [_]
      (.dispose @datetimepicker)
      (reset! @datetimepicker nil))

    om/IRenderState
    (render-state [_ {:keys [selected-date] :as state}]
      (html
       [:div
        [:h2 "Integrating Google Closure's "
         [:a {:href "http://docs.closure-library.googlecode.com/git/class_goog_ui_InputDatePicker.html"} "goog.ui.InputDatePicker"]]
        [:p "datepicker.css lifted from Google Closure demo "
         [:a {:href "http://closure-library.googlecode.com/git-history/0148f7ecaa1be5b645fabe7338b9579ed2f951c8/closure/goog/demos/index.html"} "here"] "."]
        [:span "click here -> " [:input#datetimepicker {:type "text"}]]
        (when selected-date
          [:p (str "The last selected date was: " (format-date selected-date))])]))))

(om/root datetimepicker-component {} {:target (.getElementById js/document "root")})
