(ns pbranes.sbx.layout
  (:require [helix.core :refer [defnc $ <>]]
            [helix.dom :as d]
            [pbranes.sbx.icons :refer [down-arrow-icon close-icon menu-icon]]
            [pbranes.sbx.domutils :refer [query-selector]]
            [react-router-dom :refer [Outlet, Link]]))

(defn set-sidbar-display! [value]
  (set! (.. (query-selector ".sidebar") -style -display) value))

(defn show-sidebar! []
  (set-sidbar-display! "flex"))

(defn hide-sidebar! []
  (set-sidbar-display! "none"))

(defnc Layout []
  (<>
   (d/nav
    (d/ul {:class "sidebar"}
          (d/li {:on-click hide-sidebar!} ($ Link {:to "#"} ($ close-icon {:fill "white"})))
          (d/li ($ Link {:to "/"} "PBranes"))
          (d/li ($ Link {:to "/wdc"} "Blog"))
          (d/li ($ Link {:to "#"} "product"))
          (d/li ($ Link {:to "#"} "forum"))
          (d/li ($ Link {:to "#"} "login")))
    (d/nav
     (d/ul
      (d/li {:class "hideOnmobile"} ($ Link {:to "/" :className "hideOnMobile"} "PBranes"))
      (d/li {:class "hideOnMobile"} ($ Link {:to "/wdc"} "Blog" ($ down-arrow-icon)))
      (d/li {:class "hideOnMobile"} ($ Link {:to "#"} "Product" ($ down-arrow-icon)))
      (d/li {:class "hideOnMobile"} ($ Link {:to "#"} "Forum" ($ down-arrow-icon )))
      (d/li {:class "hideOnMobile"} ($ Link {:to "#"} "Login"))
      (d/li {:class "menu-button" :on-click show-sidebar!} (d/a {:href "#"} ($ menu-icon))))))
   (d/main
    ($ Outlet))
   (d/footer "Hello footer")))

