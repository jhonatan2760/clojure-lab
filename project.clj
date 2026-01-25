(defproject clojure-lab "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [prismatic/schema "1.4.1"]
                 [compojure "1.7.0"]
                 [ring/ring-defaults "0.3.3"]
                 [ring/ring-json "0.5.1"]
                 [ring/ring-jetty-adapter "1.10.0"]
                 [ring/ring-mock "0.4.0"]
                 [com.datomic/local "1.0.291"]
                 [com.datomic/client-cloud "1.0.131"]]
  :test-paths ["test"]
  :main ^:skip-aot clojure-lab.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
