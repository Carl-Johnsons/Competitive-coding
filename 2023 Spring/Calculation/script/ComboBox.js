export default class CustomComboBox {
    constructor() {
        const cssFile = document.createElement("link");
        cssFile.rel = "stylesheet";
        cssFile.href = "style/ComboBox.css";
        document.head.appendChild(cssFile);
        this.createComboBox();
        this.selectItem = "Difference between dates";

        // this.selectItem = "Difference between dates";
        // Convert Days to Full Year
    }
    createComboBox() {
        this.Container = document.querySelector(".container");
        this.comboBoxOption = document.querySelector(".custom-combo-box > select").querySelectorAll("option");
        document.querySelector(".custom-combo-box > select").classList.add("hidden");

        // Fix Undefined value => local variable declaration
        let selectItem, choice;
        this.comboBoxContainer = document.createElement("DIV");
        this.comboBoxContainer.setAttribute("class", "combo-box");
        // Creating p tag inside combobox
        selectItem = document.createElement("p");
        selectItem.setAttribute("class", "combo-box-label");
        selectItem.innerText = this.comboBoxOption[0].innerText;
        this.comboBoxContainer.appendChild(selectItem);
        //Creating arrow inside select item
        this.arrow = document.createElement("DIV");
        this.arrow.setAttribute("class", "combo-box-arrow");
        // Creating div class outsite combobox
        this.choiceContainer = document.createElement("DIV");
        this.choiceContainer.setAttribute("class", "choice-container");
        this.choiceContainer.classList.add("hidden");
        this.choiceContainer.classList.add("Disappear-Animation");
        for (let i = 0; i < this.comboBoxOption.length; i++) {
            choice = document.createElement("DIV");
            choice.setAttribute("class", "choice");
            choice.innerText = this.comboBoxOption[i].innerText;
            choice.addEventListener("click", (e) => {
                let value = e.target.innerText;
                this.selectItem = value;
                selectItem.innerText = this.selectItem;
                this.ToggleComboBox();
            });
            this.choiceContainer.appendChild(choice);
        }
        this.Container.appendChild(this.comboBoxContainer);
        this.Container.appendChild(this.choiceContainer);
        this.comboBoxContainer.appendChild(this.arrow);
        this.comboBoxContainer.addEventListener("click", this.ToggleComboBox.bind(this));


    }

    ToggleComboBox() {
        setTimeout(() => {
            this.choiceContainer.classList.toggle("hidden");
        }, 200);
        setTimeout(() => {
            this.choiceContainer.classList.toggle("visible");
        }, 100);
        this.choiceContainer.classList.toggle("Appear-Animation");
        this.choiceContainer.classList.toggle("Disappear-Animation");
        this.arrow.classList.toggle("combo-box-arrow");
        this.arrow.classList.toggle("combo-box-arrow-selecting");
    };
    getSelectItem() {
        return this.selectItem;
    }
    destroy() {}
}