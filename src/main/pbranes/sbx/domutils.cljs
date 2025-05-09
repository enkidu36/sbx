(ns pbranes.sbx.domutils)

(defn ->class
  "Converts name to class selector"
  [name]
  (str "." name))

(defn query-selector
  "Returns DOM element for passed in query selector"
  [query]
  (js/document.querySelector query))


(defn set-background-image!
  "Updates the background image of the ht"
  [image]
    (set! (.. (query-selector "body") -style -backgroundImage) image))
