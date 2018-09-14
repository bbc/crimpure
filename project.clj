(defproject crimpjure "0.0.1-SNAPSHOT"
  :description "A clojure implementation of Crimp"
  :dependencies [[org.clojure/clojure "1.9.0"] [cheshire "5.8.0"] [pandect "0.6.1"]]
  :profiles {:dev {:dependencies [[midje "1.9.2"]]}
             ;; You can add dependencies that apply to `lein midje` below.
             ;; An example would be changing the logging destination for test runs.
             :midje {}})
             ;; Note that Midje itself is in the `dev` profile to support
             ;; running autotest in the repl.

  
