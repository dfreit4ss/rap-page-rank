(ns rap-page-rank.core
  (:require [ubergraph.core :as uber]))

(require '[clojure.string :as str])
(use 'clojure.java.io)



;; Page-rank

(defn page-rank
  [graph]
  )




(defn artists [] (list "Tim Maia" "Sabotage" "Gilberto Gil" "Caetano" "Djavan" "Pepeu" "Alceu Valença" "Moraes" "Elba"
                       "Ed Motta" "Cidade Negra" "Skank" "Jorge Ben Jor"))
(defn lyrics [] (list "resources/lyrics/Jorge Ben Jor - W Brasil" "resources/lyrics/Gabriel Pensador - Festa da Musica Tupiniquim" ))


(defn find-artist
  "Return a list of matches (artist count)"
  [text list-of-artist]
  (reduce (fn [acc x]
            (conj acc [x (count (re-seq (re-pattern x) text))]))
          [] list-of-artist))

(defn slurp-lyrics-files
  [text-path]
  (slurp text-path))

(defn reading-lyrics-files
  [lyrics artists]
  (if (empty? lyrics)
    (list "End of recursion")
    (do
      (find-artist (slurp (first lyrics)) artists)
      (reading-lyrics-files2 (rest lyrics) artists))))

;; re-pattern : string -> pattern(regex)
;; re-seq : find a regex in string




(def graph1
  (uber/graph [:a :b] [:a :c] [:b :d]))

#_(uber/pprint graph1)

;(re-seq (re-pattern (first (artists)))  (slurp "src/lyrics/Jorge Ben Jor - W Brasil"))
(reading-lyrics-files (lyrics) (artists))