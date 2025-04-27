(ns pbranes.sbx.layout
  (:require [helix.core :refer [defnc $ <>]]
            [helix.dom :as d]
            [pbranes.sbx.icons :refer [menu-icon close-icon]]
            [pbranes.sbx.domutils :refer [query-selector]]
            ["@mui/material" :refer [Typography]]
            [react-router-dom :refer [Outlet, Link]]))

(defn set-sidbar-display! [value]
  (set! (.. (query-selector ".sidebar") -style -display) value))

(defn show-sidebar! []
  (set-sidbar-display! "flex"))

(defn hide-sidebar! []
  (set-sidbar-display! "none"))

(defnc NavItem [{:keys [path label]}]
  (d/li  ($ Link {:to path}
            ($ Typography {:variant "h6"} label))))

(defnc Layout []
  (<>
    (d/nav
      (d/ul {:class "sidebar"}
        (d/li {:on-click hide-sidebar!} (d/a {:href "#"} close-icon))
        (d/li (d/a {:href "#"} "blog"))
        (d/li (d/a {:href "#"} "product"))
        (d/li (d/a {:href "#"} "forum"))
        (d/li (d/a {:href "#"} "login")))
      (d/ul
        (d/li {:class "hideonmobile"} (d/
                                       a {:href "#" :class "hideOnMobile"} "PBranes"))
        (d/li {:class "hideOnMobile"} (d/a {:href "#"} "Blog"))
        (d/li {:class "hideOnMobile"} (d/a {:href "#"} "Product"))
        (d/li {:class "hideOnMobile"} (d/a {:href "#"} "Forum"))
        (d/li {:class "hideOnMobile"} (d/a {:href "#"} "Login"))
        (d/li {:class "menu-button" :on-click show-sidebar!}(d/a {:href "#"} menu-icon))))
    ($ Outlet)))

