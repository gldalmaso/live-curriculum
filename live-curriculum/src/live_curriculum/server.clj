(ns live-curriculum.server
  (:require [live-curriculum.views.curriculum :as curriculum]
            [live-curriculum.json :as json])
  (:use [ring.util response serve]
        [ring.middleware file file-info stacktrace]
        [ring.adapter.jetty]
        [net.cgrand.moustache]))

(def routes
  (app
   (wrap-file "resources/public")
   (wrap-file-info)
   (wrap-stacktrace)
   [""]                (-> (curriculum/curriculum) response (content-type "text/html; charset=utf-8")  constantly)
   ["json" "principais"] (-> (curriculum/conhecimentos-principais) response (content-type "application/json; charset=utf-8")  constantly)
   ["json" "complementares"] (-> (curriculum/conhecimentos-complementares)
                                 response (content-type "application/json; charset=utf-8") constantly)
   ["json" "experiencia"] (-> (curriculum/experiencia) response (content-type "application/json; charset=utf-8") constantly)
   [&]        {:status 404
               :body "Page Not Found"}))

(serve routes)

