(ns crimpjure.core-test
  (:require [midje.sweet :refer :all]
            [crimpjure.core :refer :all]
            [cheshire.core :refer :all]))

(facts "about `crimjure.notation`"
       (fact "given a json null it returns a hyphen"
             (notation (generate-string nil)) => "_")
       (fact "given a json string it returns the string with an S suffix"
             (notation (generate-string "learning-day")) => "learning-dayS")
       (fact "given a json integer it returns the string with an S suffix"
             (notation (generate-string 123)) => "123N")
       (fact "given a json float it returns the string with an S suffix"
             (notation (generate-string 12.3)) => "12.3N")
       (fact "given a json true it returns the string with an S suffix"
             (notation (generate-string true)) => "trueB")
       (fact "given a json false it returns the string with an S suffix"
             (notation (generate-string false)) => "falseB")
       (fact "given a json array it returns all the array items with their suffix"
             (notation (generate-string [1, "a", 3])) => "1N3NaSA")
       (fact "given a json array containing null it returns all the array items with their suffix"
             (notation (generate-string [3, nil, 1, "1"])) => "_1N1S3NA")
       (fact "given a json array containing capital letters it returns all the array items with their suffix"
             (notation (generate-string ["a", "A", "b", "B"])) => "ASBSaSbSA")
       (fact "given a json nested array it returns all the array items with their suffix"
             (notation (generate-string ["a", 1, ["b", "2"]])) => "1N2SbSAaSA")
       (fact "given a json nested array it returns all the array items with their suffix in the right order"
             (notation (generate-string [["b", "2"], "a", 1])) => "1N2SbSAaSA")
       (fact "given a json hash it returns all the items with their suffix"
             (notation (generate-string {:a 1})) => "1NaSAH")
       (fact "given a json nested array it returns all the array items with their suffix in the right order"
             (notation (generate-string {:a {:c nil, :2 2}})) => "aS2S2NA_cSAHAH"))