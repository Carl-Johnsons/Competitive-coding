export default class CustomComboBox {

    constructor() {
        const cssFile = document.createElement("link");
        cssFile.rel = "stylesheet";
        cssFile.href = "style/ComboBox.css";
        document.head.appendChild(cssFile);
        this.name = "lol"; // lol :)?  
        this.createComboBox();
    }

    createComboBox() {
        this.Container = document.querySelector(".container");
        this.comboBoxOption = document.querySelector(".custom-combo-box > select").querySelectorAll("option");
        document.querySelector(".custom-combo-box > select").classList.add("hidden");
        this.comboBoxContainer = document.createElement("DIV");
        this.comboBoxContainer.setAttribute("class", "combo-box");
        // Creating p tag inside combobox
        this.selectItem = document.createElement("p");
        this.selectItem.setAttribute("class", "combo-box-label");
        this.selectItem.innerText = this.comboBoxOption[0].innerText;
        this.comboBoxContainer.appendChild(this.selectItem);
        //Creating arrow inside select item
        this.arrow = document.createElement("DIV");
        this.arrow.setAttribute("class", "combo-box-arrow");
        // Creating div class outsite combobox
        this.choiceContainer = document.createElement("DIV");
        this.choiceContainer.setAttribute("class", "choice-container");
        this.choiceContainer.classList.add("hidden");
        this.choiceContainer.classList.add("Disappear-Animation");
        for (let i = 0; i < this.comboBoxOption.length; i++) {
            this.choice = document.createElement("DIV");
            this.choice.setAttribute("class", "choice");
            this.choice.innerText = this.comboBoxOption[i].innerText;
            this.choice.addEventListener("click", (e) => {
                let value = e.target.innerText;
                this.selectItem.innerText = value;
                this.ToggleComboBox();

            });
            this.choiceContainer.appendChild(this.choice);
        }
        this.comboBoxContainer.addEventListener("click", () => {
            this.choice = document.querySelectorAll(".choice");
        });
        this.Container.appendChild(this.comboBoxContainer);
        this.Container.appendChild(this.choiceContainer);
        this.comboBoxContainer.appendChild(this.arrow);
        this.comboBoxContainer.addEventListener("click", this.ToggleComboBox);

        console.log(this.choiceContainer); // Ra class
    }
    ToggleComboBox() {
        console.log(this.name); // ?? djt me thang nay cung undefined
        console.log(this.choiceContainer); // undefined
        console.log(this.Container);
        console.log(this.comboBoxContainer);
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
    destroy() {}
}