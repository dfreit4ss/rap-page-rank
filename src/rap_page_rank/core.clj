(ns rap-page-rank.core)

(use 'clojure.java.io)


(defn reading-text-file
  [text-path artists]
    (with-open [rdr (reader text-path)]
      (doseq [line (line-seq rdr)]
        (if (clojure.string/includes? line "Tim Maia") ;;verify if in line have "Tim maia"
          (println "Achou")
          (println "Nao achou")))))

(re-seq #"Tim Maia" (slurp "src/lyrics/Jorge Ben Jor - W Brasil")) ;;fazer uma lista separada dos artistas

(defn artists [] (list "Tim Maia" "Sabotage" "Gilberto Gil" "Caetano" "Djavan" "Pepeu" "Alceu Valença" "Moraes" "Elba"
                       "Ed Motta" "Cidade Negra" "Skank" "Jorge Ben Jor"))


(reading-text-file "src/lyrics/Jorge Ben Jor - W Brasil" (artists))
