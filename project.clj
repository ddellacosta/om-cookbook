(defproject om-examples "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2234"]
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]
                 [om "0.6.4"]
                 [sablono "0.2.17"]]

  :plugins [[lein-cljsbuild "1.0.3"]]

  :cljsbuild {
    :builds [{:id "resize-listener"
              :source-paths ["resize-listener/src"]
              :compiler {
                :output-to "resize-listener/main.js"
                :output-dir "resize-listener/out"
                :source-map true
                :optimizations :none}}

             {:id "same-data-different-component"
              :source-paths ["same-data/src"]
              :compiler {
                :output-to "same-data/main.js"
                :output-dir "same-data/out"
                :source-map true
                :optimizations :none}}

             {:id "back-it-up"
              :source-paths ["back-it-up/src"]
              :compiler {
                :output-to "back-it-up/main.js"
                :output-dir "back-it-up/out"
                :source-map true
                :optimizations :none}}

             {:id "datetimepicker"
              :source-paths ["datetimepicker/src"]
              :compiler {
                :output-to "datetimepicker/main.js"
                :output-dir "datetimepicker/out"
                :source-map true
                :optimizations :none}}

             {:id "focus"
              :source-paths ["focus/src"]
              :compiler {
                :output-to "focus/main.js"
                :output-dir "focus/out"
                :source-map true
                :optimizations :none}}

             {:id "extend-cursor"
              :source-paths ["extend-cursor/src"]
              :compiler {
                :output-to "extend-cursor/main.js"
                :output-dir "extend-cursor/out"
                :source-map true
                :optimizations :none}}

             {:id "complex-selection"
              :source-paths ["complex-selection/src"]
              :compiler {
                :output-to "complex-selection/main.js"
                :output-dir "complex-selection/out"
                :source-map true
                :optimizations :none}}
             ]})
