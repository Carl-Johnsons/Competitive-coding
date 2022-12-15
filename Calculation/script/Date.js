import DateDiffMode from "./DateDiffMode.js";

// MENU FUNCTIONALITY
let MenuList = document.querySelector(".MenuList");
let MenuIcon = document.querySelector(".MenuIcon");
let Menubtns = document.querySelectorAll(".Menubtn");
MenuList.classList.add("MenuListMoveOut");

// DATE FUNCTIONALITY
const Container = document.querySelector(".container");
let Diff = new DateDiffMode();

//CUSTOM COMBO BOX
let comboBoxOption = document.querySelector(".custom-combo-box > select").querySelectorAll("option");
let comboBoxContainer, selectItem, choiceContainer, choice, arrow;
createComboBox();

function createComboBox() {
    document.querySelector(".custom-combo-box > select").classList.add("hidden");
    comboBoxContainer = document.createElement("DIV");
    comboBoxContainer.setAttribute("class", "combo-box");
    // Creating p tag inside combobox
    selectItem = document.createElement("p");
    selectItem.setAttribute("class", "combo-box-label");
    selectItem.innerText = comboBoxOption[0].innerText;
    comboBoxContainer.appendChild(selectItem);
    //Creating arrow inside select item
    arrow = document.createElement("DIV");
    arrow.setAttribute("class", "combo-box-arrow");
    // Creating div class outsite combobox
    choiceContainer = document.createElement("DIV");
    choiceContainer.setAttribute("class", "choice-container");
    choiceContainer.classList.add("hidden");
    choiceContainer.classList.add("Calendar-Disappear-Animation");
    for (let i = 0; i < comboBoxOption.length; i++) {
        choice = document.createElement("DIV");
        choice.setAttribute("class", "choice");
        choice.innerText = comboBoxOption[i].innerText;
        choice.addEventListener("click", (e) => {

            let value = e.target.innerText;
            selectItem.innerText = value;
            ToggleComboBox();
        });
        choiceContainer.appendChild(choice);
    }
    comboBoxContainer.addEventListener("click", () => {
        choice = document.querySelectorAll(".choice");
    });
    Container.appendChild(comboBoxContainer);
    Container.appendChild(choiceContainer);
    comboBoxContainer.appendChild(arrow);

}
comboBoxContainer.addEventListener("click", ToggleComboBox);

function ToggleComboBox() {
    setTimeout(() => {
        choiceContainer.classList.toggle("hidden");
    }, 200);
    setTimeout(() => {
        choiceContainer.classList.toggle("visible");
    }, 100);
    choiceContainer.classList.toggle("Calendar-Appear-Animation");
    choiceContainer.classList.toggle("Calendar-Disappear-Animation");
    arrow.classList.toggle("combo-box-arrow");
    arrow.classList.toggle("combo-box-arrow-selecting");
};

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