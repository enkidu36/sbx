(ns pbranes.sbx.icons
  (:require
   [helix.core :refer [defnc]]
   [helix.dom :as d]))

(defnc menu-icon
  [{:keys [size fill] :or {size "24px" fill "white"}}]
  (d/svg
    {:xmlns "http://www.w3.org/2000/svg",
     :height size,
     :viewBox "0 -960 960 960",
     :width size,
     :fill fill}
    (d/path
      {:d
       "m120-240v-80h720v80h120zm0-200v-80h720v80h120zm0-200v-80h720v80h120z"})))

(defnc close-icon
  [{:keys [size fill] :or {size "24" fill "white"}}]
  (d/svg
    {:xmlns "http://www.w3.org/2000/svg",
     :height size,
     :viewBox "0 -960 960 960",
     :width size,
     :fill fill}
    (d/path
      {:d
       "m256-200-56-56 224-224-224-224 56-56 224 224 224-224 56 56-224 224 224 224-56 56-224-224-224 224Z"})))

(defnc down-arrow-icon
  [{:keys [size fill] :or {size "24" fill "white"}}]
  (d/svg
    {:xmlns "http://www.w3.org/2000/svg",
     :height size,
     :viewBox "0 -960 960 960",
     :width size,
     :fill fill}
    (d/path {:d "M480-360 280-560h400L480-360Z"})))


