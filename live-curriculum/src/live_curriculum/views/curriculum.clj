(ns live-curriculum.views.curriculum
  (:require [net.cgrand.enlive-html :as html])
  (:use [live-curriculum.json]))

(def conhecimentos-principais
  (to-json
   {}))

(html/deftemplate curriculum "live_curriculum/views/curriculum.html"
  [])