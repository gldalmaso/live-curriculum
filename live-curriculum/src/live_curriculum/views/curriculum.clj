(ns live-curriculum.views.curriculum
  (:require [net.cgrand.enlive-html :as html])
  (:use [live-curriculum.json]))

(defn fetch-url [url]
  (html/html-resource (java.net.URL. url)))

(defn conhecimentos-principais []
  (to-json
   [{:name "java" :categories ["language" "backend" "jvm"]}
    {:name "clojure" :categories ["language" "backend" "jvm"]}
    {:name "javascript" :categories ["language" "frontend"]}
    {:name "sql" :categories ["language" "database"]}]))

(defn conhecimentos-complementares []
  (to-json
   [{:name "emacs" :categories ["editor"]}
    {:name "eclipse" :categories ["ide"]}
    {:name "postgres" :categories ["database"]}
    {:name "html/css" :categories ["frontend"]}
    {:name "unit testing" :categories ["practices"]}
    {:name "jquery" :categories ["frontend"]}]))

(defn experiencia []
  (to-json
   [{:company "Paripassu" :position "Programador java" :inicio "Junho / 2011" :fim "presente"}
    {:company "Paripassu" :position "Estagiário programador java" :inicio "Julho / 2010" :fim "Junho / 2011"}]))

(html/deftemplate curriculum "live_curriculum/views/curriculum.html"
  [])