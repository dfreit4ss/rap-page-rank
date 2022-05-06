(ns rap-page-rank.core-test
  (:require [clojure.test :refer :all]
            [rap-page-rank.core :refer :all]))


(deftest check-artist-test
  (testing "checking if pattern will match a artist"
    (is (= 7 (count (re-seq (re-pattern "Tim Maia") "Tim Maia Tim Maia Tim Maia Tim Maia Tim Maia Tim Maia Tim Maia"))))))


(deftest find-artist-test
  (testing "Testing if the function will find all artists of a list"
    (is (= [["Tim Maia" 1]
            ["Tim Outro" 1]] (find-artist (slurp "resources/lyrics/Teste - Musica Teste") '("Tim Maia" "Tim Outro"))))))

(deftest reading-lyrics-files-test
  (testing "Testing the recursion to read all lyrics"
    (is (list? (reading-lyrics-files (lyrics) (artists)))))) ;; idk how can i test this