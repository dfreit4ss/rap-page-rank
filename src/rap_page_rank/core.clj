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
(defn lyrics [] (list "src/lyrics/Gabriel Pensador - Festa da Musica Tupiniquim" "src/lyrics/Jorge Ben Jor - W Brasil"))

(defn print-matches
  [lista-de-matches]
  (println lista-de-matches))

#_(defn find-artist
  [text list-of-artist]
  (if (empty? list-of-artist)
    (list );;maybe start to insert in graphs here
    (do
      (print-matches (list (first list-of-artist)
                    (count (re-seq (re-pattern (first list-of-artist)) text)))) ;; or here
     (find-artist text (rest list-of-artist)))))

(defn find-artist
  "Return a list of matches (artist count)"
  [text list-of-artist]
  (reduce (fn [acc x]
            (conj acc [x (count (re-seq (re-pattern x) text))]))
          [] list-of-artist))

(defn slurp-lyrics-files
  [text-path]
  (slurp text-path)
  )





(defn reading-lyrics-files
  [text-path artists]
  (if (empty? text-path)
    (println "End of recursion.")
    ((println "Artist: "(first (str/split (first text-path) #"-")) "Music: "(second (str/split (first text-path) #"-")))
     (find-artist (slurp (first text-path)) artists)
     (reading-lyrics-files (rest text-path) (artists)))))

;; re-pattern : string -> pattern(regex)
;; re-seq : find a regex in string




(def graph1
  (uber/graph [:a :b] [:a :c] [:b :d]))

#_(uber/pprint graph1)

;(re-seq (re-pattern (first (artists)))  (slurp "src/lyrics/Jorge Ben Jor - W Brasil"))
(reading-lyrics-files (lyrics) (artists))