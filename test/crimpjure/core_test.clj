(ns crimpjure.core-test
  (:require [midje.sweet :refer :all]
            [crimpjure.core :refer :all]
            [cheshire.core :refer :all]))

(facts "about `crimjure.notation`"
  (fact "given a null json string it returns a hyphen"
    (notation (generate-string nil)) => "-")
  (fact "given a string json string it returns the string with an S suffix"
        (notation (generate-string "learning-day")) => "learning-dayS"))