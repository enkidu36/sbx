(ns pbranes.sbx.page.webdevcreative
  (:require [helix.core :refer [defnc]]
            [helix.dom :as d]
            [pbranes.sbx.domutils :refer [query-selector]]))

(defn body-background! []
  (set! (.. (query-selector "body") -style -backgroundImage) "url('/images/nav-logo.jpg')")
  )

(defnc WebDevCreative []
  (body-background!)
  (d/main "hello world"))


(comment
  (js/console.log (query-selector "body"))
  (js/console.log   (.. (query-selector "body") -style -backgroundImage))
  (set! (.. (query-selector "body") -style -backgroundImage) nil)
  (prn (query-selector "body")))
