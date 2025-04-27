(ns pbranes.sbx.domutils)

(defn query-selector [select]
  (js/document.querySelector select))

(.. (query-selector "body") -style -background-image)
