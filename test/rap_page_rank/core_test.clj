(ns rap-page-rank.core-test
  (:require [clojure.test :refer :all]
            [rap-page-rank.core :refer :all]))


(deftest check-artist-test
  (testing "checking if pattern will match a artist"
    (is (= 7 (count (re-seq (re-pattern "Tim Maia") "Tim Maia Tim Maia Tim Maia Tim Maia Tim Maia Tim Maia Tim Maia"))))))


(deftest find-artist-test
  (testing "Testing if the function will find all artists of a list"
    (is (= [["Tim Maia " 1]
            ["Tim Outro " 1]] (find-artist (slurp "resources/lyrics/Teste - Musica Teste") '("Tim Maia" "Tim Outro"))))))

(deftest reading-lyrics-files-test
  (testing "Testing the recursion to read all lyrics"
    (is (= [["Tim Maia" 1] ["Sabotage" 0] ["Gilberto Gil" 1] ["Caetano" 1]
            ["Djavan" 1] ["Pepeu" 1] ["Alceu Valença" 1] ["Moraes" 1] ["Elba" 1]
            ["Ed Motta" 1] ["Cidade Negra" 1] ["Skank" 1] ["Jorge Ben Jor" 1]] (reading-lyrics-files '("resources/lyrics/Gabriel Pensador - Festa da Musica Tupiniquim") '("Sabotage" "Gilberto Gil" "Caetano" "Tim Maia" "Djavan" "Pepeu" "Alceu Valença" "Moraes" "Elba"
                                                                                                                                                                                                                        "Ed Motta" "Cidade Negra" "Skank" "Jorge Ben Jor") )))))