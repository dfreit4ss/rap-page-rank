(ns rap-page-rank.core)

(use 'clojure.java.io)


(defn reading-text-file
  [text-path]
  (let [artists '("Tim maia" "tim maia" "sabotage" "sabota" "Sabotage")]
    (with-open [rdr (reader text-path)]
      (doseq [line (line-seq rdr)]
        (if (clojure.string/includes? line "Tim Maia") ;;verify if in line have Tim maia
          (println "Achou")
          (println "Nao achou"))))))

(reading-text-file "src/rap_page_rank/teste.txt")
