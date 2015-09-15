(defproject awesome-project "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.48"]
                 [reagent "0.5.1" :exclusions [cljsjs/react]]]
  :plugins [[lein-cljsbuild "1.0.6"]]
  :cljsbuild {:builds {:dev {:source-paths ["src"]
                             :compiler {:output-to "ReagentNative/index.android.js"
                                        :output-dir "target/dev-out"
                                        :optimizations :simple}}}})
