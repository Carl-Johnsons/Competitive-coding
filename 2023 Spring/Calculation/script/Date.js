import DateDiffMode from "./DateMode/DateDiffMode.js";
import CustomComboBox from "./ComboBox.js";
import ConvertDateMode from "./DateMode/ConvertDateMode.js";
import AddSubMode from "./DateMode/AddSubMode.js";

// MENU FUNCTIONALITY
let MenuList = document.querySelector(".MenuList");
let MenuIcon = document.querySelector(".MenuIcon");
let Menubtns = document.querySelectorAll(".Menubtn");
MenuList.classList.add("MenuListMoveOut");

// DATE FUNCTIONALITY
const MODE = ["Difference between dates", "Add or subtract days", "Convert Days to Full Year"];
let currentMode = MODE[0];
const Container = document.querySelector(".container");
let Diff = new DateDiffMode();
let AddSub = new AddSubMode();
let Convert = new ConvertDateMode();
let combobox = new CustomComboBox();
//Initial mode
Diff.init();

document.addEventListener("click", (e) => {
    if (combobox.getSelectItem() !== currentMode)
        check();
});


function check() {
    DestroyAll();
    console.log(combobox.getSelectItem());
    switch (combobox.getSelectItem()) {
        case "Difference between dates":
            Diff.init();
            break;
        case "Add or subtract days":
            AddSub.init();
            break;
        case "Convert Days to Full Year":
            Convert.init();
            break;
    }
    currentMode = combobox.getSelectItem();
}


function DestroyAll() {
    if (Diff.isExited)
        Diff.destroy();
    if (AddSub.isExited)
        AddSub.destroy();
    if (Convert.isExited)
        Convert.destroy();
}



//MENU FUNCTIONALITY
//DEFAULT MODE: Date

setDefaultMode();

MenuIcon.addEventListener("mouseenter", () => {
    MenuList.classList.remove("MenuListMoveOut");
    if (MenuList.classList.contains("MenuListMoveIn")) {
        MenuList.style.animation = 'none';
        MenuList.offsetHeight;
        MenuList.style.animation = null;
    }
    MenuList.classList.add("MenuListMoveIn");
});
MenuList.addEventListener("mouseleave", () => {
    MenuList.classList.remove("MenuListMoveIn");
    MenuList.classList.add("MenuListMoveOut");
});

for (let i = 0; i < Menubtns.length; i++) {
    Menubtns[i].addEventListener('click', () => {
        //Reset active mode
        for (let j = 0; j < Menubtns.length; j++) {
            Menubtns[j].classList.remove("MenuListStayActive");
        }
        if (i === 1) {
            alert("Unsupported feature! Please stay tune!");
            setDefaultMode();
        } else {
            Menubtns[i].classList.add("MenuListStayActive");
        }
    });
}

function setDefaultMode() {
    Menubtns[3].classList.add("MenuListStayActive");
}