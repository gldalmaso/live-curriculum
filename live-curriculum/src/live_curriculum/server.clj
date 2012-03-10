(ns live-curriculum.server
  (:require [live-curriculum.views.curriculum :as curriculum]
            [live-curriculum.json :as json])
  (:use [ring.util.response]
        [ring.middleware.file]
        [ring.adapter.jetty]
        [net.cgrand.moustache]))

(def routes
  (app
   (wrap-file "resources/public")
   [""]                (-> (curriculum/curriculum) response constantly)
   ["json" "principais"] (-> (curriculum/principais) response constantly)
   [&]        {:status 404
               :body "Page Not Found"}))
