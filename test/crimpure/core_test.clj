(ns crimpure.core-test
  (:require [midje.sweet :refer :all]
            [crimpure.core :refer :all]
            [cheshire.core :refer :all]))

(facts "about `crimpure/notation`"
       (fact "given a json null it returns a hyphen"
             (notation (generate-string nil)) => "_")
       (fact "given a json string it returns the string with an S suffix"
             (notation (generate-string "abc")) => "abcS")
       (fact "given a json integer it returns the string with an S suffix"
             (notation (generate-string 1)) => "1N")
       (fact "given a json float it returns the string with an S suffix"
             (notation (generate-string 1.2)) => "1.2N")
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

(facts "about `crimpure/signature`"
       (fact "given a json null it returns a hyphen"
             (signature (generate-string nil)) => "b14a7b8059d9c055954c92674ce60032")
       (fact "given a json string it returns the string with an S suffix"
             (signature (generate-string "abc")) => "c4449120506d97975c67be69719a78e2")
       (fact "given a json integer it returns the string with an S suffix"
             (signature (generate-string 1)) => "594170053719896a11eb08ee513813d5")
       (fact "given a json float it returns the string with an S suffix"
             (signature (generate-string 1.2)) => "f1ab6592886cd4b1b66ed55e73d9ab81")
       (fact "given a json true it returns the string with an S suffix"
             (signature (generate-string true)) => "6413cfeb7a89f7e0a8872f82b919c0d9")
       (fact "given a json false it returns the string with an S suffix"
             (signature (generate-string false)) => "fa39253035cfe44c8638b8f5d7a3402e")
       (fact "given a json array it returns all the array items with their suffix"
             (signature (generate-string [1, "a", 3])) => "cd1c43797d488d0f6c0d71537c64d30b")
       (fact "given a json array containing null it returns all the array items with their suffix"
             (signature (generate-string [3, nil, 1, "1"])) => "518e7bb17674f6acbb296845862a152d")
       (fact "given a json array containing capital letters it returns all the array items with their suffix"
             (signature (generate-string ["a", "A", "b", "B"])) => "f6692ab4bc94b35e61ec15c2d1891734")
       (fact "given a json nested array it returns all the array items with their suffix"
             (signature (generate-string ["a", 1, ["b", "2"]])) => "3aaa58da4841eaeb41d3726d2c6fd875")
       (fact "given a json nested array it returns all the array items with their suffix in the right order"
             (signature (generate-string [["b", "2"], "a", 1])) => "3aaa58da4841eaeb41d3726d2c6fd875")
       (fact "given a json hash it returns all the items with their suffix"
             (signature (generate-string {:a 1})) => "8cb44d69badda0f34b0bab6bb3e7fdbf")
       (fact "given a json nested array it returns all the array items with their suffix in the right order"
             (signature (generate-string {:a {:c nil, :2 2}})) => "bff3538075e4007c7679a7ba0d0a5f30"))