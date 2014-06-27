(defproject om-examples "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2234"]
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

             ]}
  )

             ;; {:id "unmount"
             ;;  :source-paths ["src" "examples/unmount/src"]
             ;;  :compiler {
             ;;    :output-to "examples/unmount/main.js"
             ;;    :output-dir "examples/unmount/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "mouse"
             ;;  :source-paths ["src" "examples/mouse/src"]
             ;;  :compiler {
             ;;    :output-to "examples/mouse/main.js"
             ;;    :output-dir "examples/mouse/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "multiroot"
             ;;  :source-paths ["src" "examples/multiroot/src"]
             ;;  :compiler {
             ;;    :output-to "examples/multiroot/main.js"
             ;;    :output-dir "examples/multiroot/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "counters"
             ;;  :source-paths ["src" "examples/counters/src"]
             ;;  :compiler {
             ;;    :output-to "examples/counters/main.js"
             ;;    :output-dir "examples/counters/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "animation"
             ;;  :source-paths ["src" "examples/animation/src"]
             ;;  :compiler {
             ;;    :output-to "examples/animation/main.js"
             ;;    :output-dir "examples/animation/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "shared"
             ;;  :source-paths ["src" "examples/shared/src"]
             ;;  :compiler {
             ;;    :output-to "examples/shared/main.js"
             ;;    :output-dir "examples/shared/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "typeahead"
             ;;  :source-paths ["src" "examples/typeahead/src"]
             ;;  :compiler {
             ;;    :output-to "examples/typeahead/main.js"
             ;;    :output-dir "examples/typeahead/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "sortable"
             ;;  :source-paths ["src" "examples/sortable/src"]
             ;;  :compiler {
             ;;    :output-to "examples/sortable/main.js"
             ;;    :output-dir "examples/sortable/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "instrument"
             ;;  :source-paths ["src" "examples/instrument/src"]
             ;;  :compiler {
             ;;    :output-to "examples/instrument/main.js"
             ;;    :output-dir "examples/instrument/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "stateful"
             ;;  :source-paths ["src" "examples/stateful/src"]
             ;;  :compiler {
             ;;    :output-to "examples/stateful/main.js"
             ;;    :output-dir "examples/stateful/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "harmful"
             ;;  :source-paths ["src" "examples/harmful/src"]
             ;;  :compiler {
             ;;    :output-to "examples/harmful/main.js"
             ;;    :output-dir "examples/harmful/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "mixins"
             ;;  :source-paths ["src" "examples/mixins/src"]
             ;;  :compiler {
             ;;    :output-to "examples/mixins/main.js"
             ;;    :output-dir "examples/mixins/out"
             ;;    :source-map true
             ;;    :optimizations :none}}
             ;; {:id "tests"
             ;;  :source-paths ["src" "examples/tests/src"]
             ;;  :compiler {
             ;;    :output-to "examples/tests/main.js"
             ;;    :output-dir "examples/tests/out"
             ;;    :source-map true
             ;;    :optimizations :none}}]})
