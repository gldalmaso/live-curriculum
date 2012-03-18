(defproject live-curriculum "0.1.0-SNAPSHOT"
            :description "FIXME: write this!"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [enlive "1.0.0-SNAPSHOT"]
                           [ring "1.0.2"]
                           [net.cgrand/moustache "1.0.0-SNAPSHOT"]
                           [clj-stacktrace "0.2.4"]]
            :dev-dependencies [[lein-ring "0.5.4"]
                               [ring-serve "0.1.1"]]
            :ring {:handler live-curriculum.server/routes})
