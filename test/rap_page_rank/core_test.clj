(ns rap-page-rank.core-test
  (:require [clojure.test :refer :all]
            [rap-page-rank.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(deftest check-artist-test
  (testing "checking if pattern will match a artist"
    (is ((re-seq (re-pattern (first (list-of-artist))) (slurp text))))))