(ns pbranes.sbx.layout
  (:require [helix.core :refer [defnc fnc $ <>]]
            [helix.dom :as d]
            [pbranes.sbx.domutils :refer [->class query-selector]]
            [pbranes.sbx.icons :refer [close-icon down-arrow-icon menu-icon]]
            [react-router-dom :refer [Outlet, Link]]
            [helix.hooks :as hooks]))

(defn set-sidbar-display! [value]
  (set! (.. (query-selector ".sidebar") -style -display) value))

(defn show-sidebar! []
  (set-sidbar-display! "flex"))

(defn hide-sidebar! []
  (set-sidbar-display! "none"))

(defnc Sidbar [{:keys [children]}]
  (d/nav
   (d/ul {:class "sidebar"}
         (d/li {:on-click hide-sidebar! :style {:padding-left 60}} ($ Link {:to "#"} ($ close-icon {:fill "white"})))
         children)))

(defnc SideItem [{:keys [children]}]
  (d/li children))

(defnc NavItem [{:keys [children] :as props}]
  (d/li {:className "hideOnMobile"} children
    (d/div {:class "menu-line"})))

(defnc Navbar [{:keys [children]}]
  (d/nav
   (d/ul children)))

(defn show-menu [menu]
  (let [menu (query-selector (->class menu))]
    (set! (.. menu -style -display) "flex")))

(defn hide-menu [menu]
  (let [menu (query-selector (->class menu))]
    (set! (.. menu -style -display) "none")))

(defnc dropdown-link [{:keys [href children]:as props}]
  (d/a {:href href :class "dropdown-link"} children))

(defnc dropdown
  "Dropdown menu component"
  [{:keys [name menu-class children] :or {name "dropdown"}}]
  (d/div
   {:class "dropdown-root-link" :onMouseOver #(show-menu menu-class)
    :style {:position "relative"}} name ($ down-arrow-icon {:class ".down-icon"})

   (when children
     (d/div {:class (str "dropdown-wrapper " menu-class)
             :onMouseOut #(hide-menu menu-class)}

        ;; Transparent menu item
        ;; to fill in the gap between the menu lable
        ;; and the menu so that mouse out will work
            (d/div {:style {:background-color "transparent"
                            :height "64px"}})

            (d/div {:class "dropdown-menu"} children)))))

(defnc Layout []
  (<>
   ;; ($ Sidbar
   ;;    ($ SideItem
   ;;       ($ Link {:to "/"} "Environment Mapping")))
   ($ Navbar
      ($ NavItem
         ($ Link {:to "/" :className "nav-logo hideOnMobile"} "Wagon Station"))

      ($ NavItem
         ($ dropdown {:name "Science Groups" :menu-class "groups-dropdown"}
            ($ dropdown-link {:href "#"} "Enviromental Mapping")
            ($ dropdown-link {:href "#"} "Natural Hazards")
            ($ dropdown-link {:href "#"} "Ecosystem Services")
            ($ dropdown-link {:href "#"} "Forest & Agricultural Management")
            ))
          
      ($ NavItem
         ($ dropdown {:name "Solutions" :menu-class "solutions-dropdown"}
            ($ dropdown-link {:href "#"} "Enviromental Mapping")
            ($ dropdown-link {:href "#"} "Natural Hazards")
            ($ dropdown-link {:href "#"} "Ecosystem Services")
            ($ dropdown-link {:href "#"} "Forest & Agricultural Management")))

      ($ NavItem
         ($ Link {:to "/"} "Login"))

      (d/li {:className "menu-button"} (d/a {:href "#" :on-click show-sidebar!} ($ menu-icon)))
      )
   (d/main
    ($ Outlet))
   (d/footer)))

