(ns rap-page-rank.core)

(use 'clojure.java.io)

(defn reading-text-file
  [text-path]

  (with-open [rdr (reader text-path)]
    (doseq [line (line-seq rdr)]
      (if (= line "Tim Maia")
        (println "Achou o tim maia!")
        (println "Nao achou o tim maia")))))

(reading-text-file "teste.txt")

