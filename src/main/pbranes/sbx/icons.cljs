(ns pbranes.sbx.icons
  (:require  [helix.dom :as d]))

(def menu-icon (d/svg
                {:xmlns "http://www.w3.org/2000/svg",
                 :height "24px",
                 :viewBox "0 -960 960 960",
                 :width "24px",
                 :fill "black"}
                (d/path
                 {:d
                  "M120-240v-80h720v80H120Zm0-200v-80h720v80H120Zm0-200v-80h720v80H120Z"})))

(def close-icon (d/svg
                 {:xmlns "http://www.w3.org/2000/svg",
                  :height "24px",
                  :viewBox "0 -960 960 960",
                  :width "24px",
                  :fill "black"}
                 (d/path
                  {:d
                   "m256-200-56-56 224-224-224-224 56-56 224 224 224-224 56 56-224 224 224 224-56 56-224-224-224 224Z"})))

(def down-arrow-icon (d/svg
                      {:xmlns "http://www.w3.org/2000/svg",
                       :height "24px",
                       :viewBox "0 -960 960 960",
                       :width "24px",
                       :fill "#e3e3e3"}
                      (d/path {:d "M480-360 280-560h400L480-360Z"})))
