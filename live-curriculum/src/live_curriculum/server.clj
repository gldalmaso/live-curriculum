(ns live-curriculum.server
  (:require [live-curriculum.views.curriculum :as curriculum])
  (:use [ring.util.response]
        [ring.middleware.file]
        [ring.adapter.jetty]
        [net.cgrand.moustache]))

(def routes
  (app
   (wrap-file "resources/public")
   [""]       (-> (curriculum/curriculum) response constantly)
   [&]        {:status 404
               :body "Page Not Found"}))
