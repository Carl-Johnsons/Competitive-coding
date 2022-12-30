export default class Menu {
    constructor() {
        this.init();
        // Initialize item array
        this.currentMode = "";
        this.items = [];
        this.itemsRef = [];
        this.itemActive = [];
        this.appendCSS();
    }
    appendCSS() {
        this.cssFile = document.createElement("link");
        this.cssFile.rel = "stylesheet";
        this.cssFile.href = "/style/MenuStyle.css";
        document.head.appendChild(this.cssFile);
    }
    init() {
        this.MenuSection = document.createElement("section");
        this.MenuSection.setAttribute("class", "menu-section");

        this.MenuIcon = document.createElement("img");
        this.MenuIcon.setAttribute("class", "menu-icon")
        this.MenuIcon.src = "/res/MenuIcon.png";

        this.Panel = document.createElement("div");
        this.Panel.setAttribute("class", "menu-panel");

        this.wholeBg = document.createElement("div");
        this.wholeBg.setAttribute("class", "web-whole-bg");

        this.bodyCover = document.createElement("div");
        this.bodyCover.setAttribute("class", "body-cover hidden");

        // Append child
        this.MenuSection.appendChild(this.MenuIcon);
        this.MenuSection.appendChild(this.Panel);
        this.MenuSection.appendChild(this.bodyCover);
        document.body.insertAdjacentElement("afterbegin", this.MenuSection);
        document.body.insertAdjacentElement("afterbegin", this.wholeBg);
        this.makeMenuFunctional();
    }

    addItem(title, reference) {
        let ItemLenght = this.items.length;
        this.items[ItemLenght] = document.createElement("button");
        this.items[ItemLenght].setAttribute("class", "menu-item menu-item-anchor menu-btn hidden");
        this.items[ItemLenght].innerText = title;

        this.itemsRef[ItemLenght] = document.createElement("a");
        this.itemsRef[ItemLenght].setAttribute("class", "menu-item-anchor");
        this.itemsRef[ItemLenght].style.pointerEvents = 'none';
        this.itemsRef[ItemLenght].href = reference;

        this.itemActive[ItemLenght] = false;

        this.itemsRef[ItemLenght].appendChild(this.items[ItemLenght]);
        this.Panel.appendChild(this.itemsRef[ItemLenght]);
    }
    setItemActive(index, mode) {
        this.currentMode = this.items[index].innerText;
        for (let i = 0; i < this.items.length; i++) {
            this.itemActive[i] = false;
        }
        this.itemActive[index] = mode;
        console.log({ test: this.itemActive });
        this.UpdateItem();
    }
    UpdateItem() {
        let len = this.items.length;
        for (let i = 0; i < len; i++) {
            if (this.itemActive[i]) {
                this.items[i].classList.add("menu-item-active");
                break;
            } else {
                this.items[i].classList.remove("menu-item-active");
            }
        }
    }
    makeMenuFunctional() {
        this.MenuIcon.addEventListener("click", e => {
            this.MenuIconClickHandler();
        });
        this.bodyCover.addEventListener("click", e => {
            this.MenuIconClickHandler();
        });
    }
    MenuIconClickHandler() {

        if (this.Panel.classList.contains("moveIn")) {
            this.Panel.classList.toggle("moveIn");
            this.Panel.classList.toggle("moveOut");
            this.bodyCover.classList.toggle("hidden");
        } else {
            this.Panel.classList.add("moveIn");
            this.Panel.classList.remove("moveOut");
            this.bodyCover.classList.remove("hidden")
        }
        this.MenuIcon.classList.add("IconAnim");
        this.items.forEach((index) => {
            index.classList.remove("hidden");
        })
    }

}