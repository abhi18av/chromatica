(defproject chromatica "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [

                [org.clojure/clojure "1.9.0-beta1"]
                 [org.clojure/clojurescript "1.9.908" :scope "provided"]
                 [com.cognitect/transit-clj "0.8.300"]
                 [org.clojure/tools.namespace "0.2.11"]
                
                ;; added the core.async in puppeteer branch
                 [org.clojure/core.async "0.3.443"]
                  [funcool/promesa "1.9.0"]



                [environ "1.1.0"]

                             [com.cemerick/piggieback "0.2.2"]
                             [org.clojure/tools.nrepl "0.2.13"]
                             [lein-doo "0.1.7"]
                             [reloaded.repl "0.2.3"]
                 ]


     :plugins [[lein-cljsbuild "1.1.6"]]


;              :plugins [ [lein-doo "0.1.7"]]



     :min-lein-version "2.6.1"


     :source-paths ["src/clj" "src/cljs" "src/cljc"]

     :test-paths ["test/clj" "test/cljc"]

  ;;   :clean-targets ^{:protect false} [:target-path :compile-path "resources/public/js"]

     :uberjar-name "chromatica.jar"

  ;;   ;; nREPL by default starts in the :main namespace, we want to start in `user`
  ;;   ;; because that's where our development helper functions like (go) and
  ;;   ;; (browser-repl) live.
;    :repl-options {:init-ns user}

      :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

    :cljsbuild {:builds
                [{:id "puppeteer"
                  :source-paths ["src/cljc" "src/cljs"]
                  :compiler {:main chromatica.core
                             :target :nodejs
                             ;:asset-path "js/compiled/out"
                             :output-to "resources/public/js/compiled/chromatica.js"
                             :output-dir "resources/public/js/compiled/out"
                             :pretty-print true
                             :optimizations :none
                             ;:optimizations :advanced :simple :whitespace :none
                             :parallel-build true
                             :npm-deps {:chalk "2.1.0"
                                        :puppeteer "0.11.0"}
                             :install-deps true
                             :source-map-timestamp true
                             ;:source-map true
                             :warnings false}}]}


;  :main ^:skip-aot chromatica.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

