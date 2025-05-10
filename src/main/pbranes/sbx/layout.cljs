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

(defnc Sidbar []
  (d/nav
   (d/ul {:class "sidebar"}
         (d/li {:on-click hide-sidebar!} ($ Link {:to "#"} ($ close-icon {:fill "white"})))
         (d/li ($ Link {:class "nav-logo" :to "/"} "PBranes"))
         (d/li ($ Link {:to "/wdc"} "Blog"))
         (d/li ($ Link {:to "#"} "product"))
         (d/li ($ Link {:to "#"} "forum"))
         (d/li ($ Link {:to "#"} "login")))))

(defnc NavItem [{:keys [children] :as props}]
  (d/li {:className "hideOnMobile"} children))

(defnc Navbar [{:keys [children] :as props}]
  (d/nav
   (d/ul children)))

(defn show-menu [menu]
  (let [menu (query-selector (->class menu))]
    (set! (.. menu -style -display) "flex")))

(defn hide-menu [menu]
  (let [menu (query-selector (->class menu))]
    (set! (.. menu -style -display) "none")))

(defnc dropdown-link [props]
   (d/a {:href (:href props) :class "dropdown-link"} (:children props)))

(defnc dropdown
  "Dropdown menu component"
  [{:keys [name menu-class children] :or {name "dropdown"}}]
  (d/a
    {:onMouseOver #(show-menu menu-class)
     :style {:position "relative"}} name ($ down-arrow-icon)

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
    ;;   ($ Sidbar)
   ($ Navbar
      ($ NavItem
         ($ Link {:to "/" :className "nav-logo hideOnMobile"} "Pbranes"))
      
      ($ NavItem
         ($ dropdown {:name "Blog" :menu-class "blog-dropdown"}
            ($ dropdown-link {:href "#"} "Enviromental Mapping")
            ($ dropdown-link {:href "#"} "Natural Hazards")
            ($ dropdown-link {:href "#"} "Ecosystem Services")
            ($ dropdown-link {:href "#"} "Forest & Agricultural Management")))
      
      ($ NavItem
         ($ dropdown {:name "Forum" :menu-class "forum-dropdown"}
            ($ dropdown-link "forum menu")
            ($ dropdown-link "another item in menu")))
      
      ($ NavItem
         ($ Link {:to "/"} "Login"))
      (d/li {:className "menu-button"} (d/a {:href "#"} ($ menu-icon))))
   (d/main
    ($ Outlet))
   (d/footer)))

