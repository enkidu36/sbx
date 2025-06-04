(ns pbranes.sbx.page.home
  (:require [helix.core :refer [defnc $]]
            [helix.hooks :as hooks]
            [helix.dom :as d]
            [pbranes.sbx.domutils :refer [set-background-image!]]))

(defn init []

  (set-background-image! "url('/images/beast-n-friend.png')"))

(defnc Home []
  (hooks/use-effect
    :once
    (init))

  (let [[state set-state] (hooks/use-state {:name ""})]

    ;; (d/div {:style {:display "flex" :gap 20 :border "2px solid yellow" :max-width 100 :position "relative"
    ;;                 }}
    ;;        (d/div {:style {:background-color "red" :width "30px" :height "30px"}} "")
    ;;        (d/div {:style {:border "2px solid black" :position "absolute" :top 32 :left -2 :display "flex" :justify-content "stretch" :flex-direction "column" :width "800px"}}
    ;;               (d/div {:style {:background-color "blue" :min-width 30 :min-height 30}} "hello?")
    ;;               (d/div {:style {:background-color "blue" :min-width 30 :min-height 30}} "")
    ;;               (d/div {:style {:background-color "blue" :min-width 30 :min-height 30}} "")
    ;;               (d/div {:style {:background-color "blue" :min-width 30 :min-height 30}} "")
    ;;               (d/div {:style {:background-color "blue" :min-width 30 :min-height 30}} "")))
    ))
