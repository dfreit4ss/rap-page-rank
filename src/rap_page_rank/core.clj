(ns rap-page-rank.core)

(require '[clojure.string :as str])
(use 'clojure.java.io)


(defn artists [] (list "Tim Maia" "Sabotage" "Gilberto Gil" "Caetano" "Djavan" "Pepeu" "Alceu Valença" "Moraes" "Elba"
                       "Ed Motta" "Cidade Negra" "Skank" "Jorge Ben Jor"))
(defn lyrics [] (list "src/lyrics/Gabriel Pensador - Festa da Musica Tupiniquim" "src/lyrics/Jorge Ben Jor - W Brasil"))

(defn find-artist
  [text list-of-artist]
  (if (empty? (rest list-of-artist))
    ;(reading-text-file ())
    (println "End of recursion")
    ((print (first list-of-artist) " -> ")
     (println (count (re-seq (re-pattern (first list-of-artist)) text)))
     (find-artist text (rest list-of-artist)))))


(defn reading-text-file
  [text-path artists]
  (if  (not (and (empty? text-path) (empty? artists)))
    ((println "Artist: "(first (str/split (first text-path) #"-")) "Music: "(second (str/split (first text-path) #"-")))
     (find-artist (slurp (first text-path)) artists))
  (println "Empty lists")))

;; re-pattern : string -> pattern(regex)
;; re-seq : find a regex in string

;(re-seq (re-pattern (first (artists)))  (slurp "src/lyrics/Jorge Ben Jor - W Brasil"))
(reading-text-file (lyrics) (artists))
