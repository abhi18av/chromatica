(ns chromatica.core
  (:require [cljs.nodejs :as nodejs]))

(def chalk (js/require "chalk"))
(console.log (chalk.blue "blue"))


(nodejs/enable-util-print!)
(println "Hello from the Node!")
(def -main (fn [] nil))
(set! *main-cli-fn* -main) ;; this is required