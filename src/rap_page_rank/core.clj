(ns rap-page-rank.core)

(use 'clojure.java.io)


(defn find-artist
  [text list-of-artist]
  (if (empty? (list-of-artist))
    (println "Fim")
    ((println (re-seq (re-pattern (first (list-of-artist))) (slurp text)))
     (find-artist text (rest list-of-artist)))))

(defn artists [] (list "Tim Maia" "Sabotage" "Gilberto Gil" "Caetano" "Djavan" "Pepeu" "Alceu Valença" "Moraes" "Elba"
                       "Ed Motta" "Cidade Negra" "Skank" "Jorge Ben Jor"))

(defn reading-text-file
  [text-path artists]
  (find-artist (slurp text-path) artists));; verify if in line have artists

;; re-pattern : string -> pattern(regex)
;; re-seq : find a regex in string

;(re-seq (re-pattern (first (artists)))  (slurp "src/lyrics/Jorge Ben Jor - W Brasil"))
(reading-text-file "src/lyrics/Jorge Ben Jor - W Brasil" (artists))
