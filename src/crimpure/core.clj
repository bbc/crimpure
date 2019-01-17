(ns crimpure.core
  (:require [cheshire.core :as json]
            [clojure.string :as str]
            [pandect.algo.md5 :as digest]))

(defn- map-entry-to-seq [me]
  (seq [(name (key me)) (val me)]))

(defn notation [obj]
  (cond
    (map-entry? obj) (notate (map-entry-to-seq obj))
    (coll? obj) (str (str/join (map notate (sort-by str obj))) (if (map? obj) "H" "A"))
    (boolean? obj) (str obj "B")
    (number? obj) (str obj "N")
    (string? obj) (str (name obj) "S")
    (nil? obj) "_"))

(defn notation-json [json]
  (let [parsed (json/parse-string json true)]
    (notation parsed)))

(defn signature [json]
  (digest/md5 (notation json)))