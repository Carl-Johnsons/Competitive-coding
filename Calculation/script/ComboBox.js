export default class CustomComboBox {
    constructor() {
        const cssFile = document.createElement("link");
        cssFile.rel = "stylesheet";
        cssFile.href = "style/ComboBox.css";
        document.head.appendChild(cssFile);
        this.createComboBox();
    }

    createComboBox() {
        this.Container = document.querySelector(".container");
        this.comboBoxOption = document.querySelector(".custom-combo-box > select").querySelectorAll("option");
        document.querySelector(".custom-combo-box > select").classList.add("hidden");

        // Fix Undefined value => local variable declaration
        let comboBoxContainer, selectItem, arrow, choiceContainer, choice;
        comboBoxContainer = document.createElement("DIV");
        comboBoxContainer.setAttribute("class", "combo-box");
        // Creating p tag inside combobox
        selectItem = document.createElement("p");
        selectItem.setAttribute("class", "combo-box-label");
        selectItem.innerText = this.comboBoxOption[0].innerText;
        comboBoxContainer.appendChild(selectItem);
        //Creating arrow inside select item
        arrow = document.createElement("DIV");
        arrow.setAttribute("class", "combo-box-arrow");
        // Creating div class outsite combobox
        choiceContainer = document.createElement("DIV");
        choiceContainer.setAttribute("class", "choice-container");
        choiceContainer.classList.add("hidden");
        choiceContainer.classList.add("Disappear-Animation");
        for (let i = 0; i < this.comboBoxOption.length; i++) {
            choice = document.createElement("DIV");
            choice.setAttribute("class", "choice");
            choice.innerText = this.comboBoxOption[i].innerText;
            choice.addEventListener("click", (e) => {
                let value = e.target.innerText;
                selectItem.innerText = value;
                ToggleComboBox();

            });
            choiceContainer.appendChild(choice);
        }
        this.Container.appendChild(comboBoxContainer);
        this.Container.appendChild(choiceContainer);
        comboBoxContainer.appendChild(arrow);
        comboBoxContainer.addEventListener("click", ToggleComboBox);

        function ToggleComboBox() {
            setTimeout(() => {
                choiceContainer.classList.toggle("hidden");
            }, 200);
            setTimeout(() => {
                choiceContainer.classList.toggle("visible");
            }, 100);
            choiceContainer.classList.toggle("Appear-Animation");
            choiceContainer.classList.toggle("Disappear-Animation");
            arrow.classList.toggle("combo-box-arrow");
            arrow.classList.toggle("combo-box-arrow-selecting");
        };
    }
    destroy() {}
}