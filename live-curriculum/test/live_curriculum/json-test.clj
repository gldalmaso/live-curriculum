(ns json-test
  (:use [clojure.test])
  (:require [live-curriculum.json :as json]))

(deftest json-parser
  (is (= "{\"atribute\":\"string\"}" (json/to-json {:atribute "string"})))
  (is (= "{\"atribute\":5}" (json/to-json {:atribute 5})))
  (is (= "{\"atribute\":5.1134}" (json/to-json {:atribute 5.1134})))
  (is (= "\"string\"" (json/to-json "string")))
  (is (= "5" (json/to-json 5)))
  (is (= "5.1134" (json/to-json 5.1134)))
  (is (= "{\"atribute\":{\"inner-atribute\":5.1134}}" (json/to-json {:atribute {:inner-atribute 5.1134}})))
  (is (= "[1,\"string\",5.1134,{\"atribute\":5}]" (json/to-json [1 "string" 5.1134 {:atribute 5}]))))