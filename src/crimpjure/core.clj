(ns crimpjure.core
  (:require [cheshire.core :as json]
            [clojure.string :as str]))

(defn listy? [obj]
  (or (seq? obj) (vector? obj) (list? obj)))

(defn- map-entry-to-seq [me]
  (seq [(name (key me)) (val me)]))

(defn- notate [obj]
  (cond
    (map-entry? obj) (notate (map-entry-to-seq obj))
    (map? obj) (str (str/join (map notate (sort-by str obj))) "H")
    (listy? obj) (str (str/join (map notate (sort-by str obj))) "A")
    (boolean? obj) (str obj "B")
    (number? obj) (str obj "N")
    (string? obj) (str (name obj) "S")
    (nil? obj) "_"))

(defn notation [json]
  (let [parsed (json/parse-string json true)]
    (notate parsed)))