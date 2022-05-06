(ns rap-page-rank.core
  (:require [ubergraph.core :as uber]))

(require '[clojure.string :as str])
(use 'clojure.java.io)


(defn artists [] (list "Tim Maia" "Sabotage" "Gilberto Gil" "Caetano" "Djavan" "Pepeu" "Alceu Valença" "Moraes" "Elba"
                       "Ed Motta" "Cidade Negra" "Skank" "Jorge Ben Jor" ))
(defn lyrics [] (list "resources/lyrics/Jorge Ben Jor - W Brasil" "resources/lyrics/Gabriel Pensador - Festa da Musica Tupiniquim" ))



;; Page-rank

(def page-rank-graph (uber/graph))


(defn insert-in-graph
  [vector-of-matches artist-name ]
  (if (= (first vector-of-matches) artist-name)
    (uber/pprint page-rank-graph)
    (if (= 0 (second (first vector-of-matches)))
      (insert-in-graph (rest vector-of-matches) artist-name)
      (do
        (uber/add-directed-edges page-rank-graph [artist-name
                                                  (first (first vector-of-matches))
                                                  (second (first vector-of-matches))])
        (insert-in-graph (rest vector-of-matches) artist-name)))))

(defn page-rank
  [vector-of-matches]
  (insert-in-graph vector-of-matches (last vector-of-matches)))


(defn find-artist
  "Return a list of matches (artist count)"
  [text list-of-artist]
  (reduce (fn [acc x]
            (conj acc [x (count (re-seq (re-pattern x) text))]))
          [] list-of-artist))


(defn reading-lyrics-files
  [lyrics artists]
  (if (empty? lyrics)
    (list)
    (do
      (page-rank (conj (find-artist (slurp (first lyrics)) artists) (first (split-with #"-" (str/split (first lyrics) #"\W" 3)))))
      (reading-lyrics-files (rest lyrics) artists))))

;; re-pattern : string -> pattern(regex)
;; re-seq : find a regex in string

;(re-seq (re-pattern (first (artists)))  (slurp "src/lyrics/Jorge Ben Jor - W Brasil"))
(reading-lyrics-files (lyrics) (artists))
;(uber/pprint page-rank-graph)