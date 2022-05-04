(ns rap-page-rank.core-test
  (:require [clojure.test :refer :all]
            [rap-page-rank.core :refer :all]))


(deftest check-artist-test
  (testing "checking if pattern will match a artist"
    (is (= 7 (count (re-seq (re-pattern "Tim Maia")  "Tim Maia Tim Maia Tim Maia Tim Maia Tim Maia Tim Maia Tim Maia"))))))