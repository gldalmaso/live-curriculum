(ns live-curriculum.server
  (:require [live-curriculum.views.curriculum :as curriculum]
            [live-curriculum.json :as json])
  (:use [ring.util.response]
        [ring.middleware.resource]
        [ring.adapter.jetty]
        [net.cgrand.moustache]))

(def routes
  (app
   (wrap-resource "public")
   [""]                (-> (curriculum/curriculum) response constantly)
   ["json" "principais"] (-> (curriculum/conhecimentos-principais) response constantly)
   ["json" "complementares"] (-> (curriculum/conhecimentos-complementares) response constantly)
   ["json" "experiencia"] (-> (curriculum/experiencia) response constantly)
   [&]        {:status 404
               :body "Page Not Found"}))
