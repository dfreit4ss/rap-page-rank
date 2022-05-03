(ns rap-page-rank.core)

(use 'clojure.java.io)

(defn reading-text-file
  [text-path artists]
  (println (re-seq #"Tim Maia" (slurp text-path))));; verify if in line have "Tim maia"

;(re-seq #"Tim Maia" (slurp "src/lyrics/Jorge Ben Jor - W Brasil")) ;;fazer uma lista separada dos artistas

(defn artists [] (list "Tim Maia" "Sabotage" "Gilberto Gil" "Caetano" "Djavan" "Pepeu" "Alceu Valença" "Moraes" "Elba"
                       "Ed Motta" "Cidade Negra" "Skank" "Jorge Ben Jor"))


(reading-text-file "src/lyrics/Jorge Ben Jor - W Brasil" (artists))
