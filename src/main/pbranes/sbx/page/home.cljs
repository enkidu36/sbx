(ns pbranes.sbx.page.home
  (:require [helix.core :refer [defnc $]]
            [helix.hooks :as hooks]
            [helix.dom :as d]))

(defn init []
  (js/console.log "call to init function"))

(defnc Home []
  (hooks/use-effect
    :once
    (init))

  (let [[state set-state] (hooks/use-state {:name ""})]

    (d/div

      )))
