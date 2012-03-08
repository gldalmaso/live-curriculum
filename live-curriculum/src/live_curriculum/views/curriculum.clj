(ns live-curriculum.views.curriculum
  (:require [net.cgrand.enlive-html :as html]))

(html/deftemplate curriculum "live_curriculum/views/curriculum.html"
  []
  [:div.contato] (html/content "changed again"))