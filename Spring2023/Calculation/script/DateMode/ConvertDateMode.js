import CustomDay from "./CustomDay.js";

export default class ConvertDateMode {
    constructor() {

        this.isExited = false;
    }
    init() {
        const cssFile = document.createElement("link");
        cssFile.rel = "stylesheet";
        cssFile.href = "style/DateMode/ConvertDayMode.css";
        document.head.appendChild(cssFile);
        // APPEND CSS FILE
        this.isExited = true;
        this.Converter = new CustomDay();

        this.Container = document.querySelector(".container");
        this.Input = document.createElement("input");
        this.Input.setAttribute("type", "text");
        this.Input.setAttribute("class", "DayInput");
        this.Input.setAttribute("maxlength", "7");
        this.Input.placeholder = "  Example : 10000";
        this.Input.addEventListener("input", (e) => {
            let value = this.Input.value;
            console.log({ value });
            this.Result.innerText = this.Converter.DaysToFullYear(value, "0");
        });

        this.Result = document.createElement("div");
        this.Result.setAttribute("class", "Label Result");
        this.Result.innerText = "0";

        // Container append child
        this.Container.appendChild(this.Input);
        this.Container.appendChild(this.Result);
    }
    destroy() {
        this.isExited = false;
        this.Container.removeChild(this.Input);
        this.Container.removeChild(this.Result);
    }
}