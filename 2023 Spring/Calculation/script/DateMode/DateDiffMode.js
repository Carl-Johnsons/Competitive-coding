import Calendar from "../Calendar.js";
import CustomDay from "./CustomDay.js"
export default class DateDiffMode {

    constructor() {
        this.isExited = false;
    }
    init() {
        this.isExited = true;
        const dates = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
        const Months = ["January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        this.AppendCSSFile();
        this.creatingObserver();
        this.CreatingAllElements();

        //             HANDLING DATA
        this.Datebtn = document.querySelectorAll(".Datebtn");
        this.RESULT = document.querySelector(".Result");
        this.RESULTINDAY = document.querySelector(".ResultInDay");
        this.Calendarbtns = document.querySelectorAll(".btn");
        this.Calendars = document.querySelectorAll(".Calendar");

        this.DateSelected = [];
        for (let i = 0; i < this.Calendarbtns.length; i++) {
            this.DateSelected[i] = new CustomDay();
        }
        this.DateCalc = new CustomDay();
        this.FirstCalendar.setToday();
        this.SecondCalendar.setToday();
        this.Start();
    }
    AppendCSSFile() {
        const cssFile = document.createElement("link");
        cssFile.rel = "stylesheet";
        cssFile.href = "style/DateMode/DateDiffMode.css";
        document.head.appendChild(cssFile);
    }
    CreatingAllElements() {
        this.Container = document.querySelector(".container");
        if (this.Container === undefined) {
            this.Container = document.createElement("Div");
            this.Container.setAttribute("class", "container");
            document.body.appendChild(this.Container);
        }
        //                      Creating the label
        this.btnFromLabel = document.createElement("Div");
        this.btnFromLabel.setAttribute("class", "Label");
        this.btnFromLabel.innerText = "From";

        this.btnToLabel = document.createElement("Div");
        this.btnToLabel.setAttribute("class", "Label");
        this.btnToLabel.innerText = "To";

        this.DiffLabel = document.createElement("Div");
        this.DiffLabel.setAttribute("class", "Label");
        this.DiffLabel.innerText = "Difference";

        this.ResultLabel = document.createElement("Div");
        this.ResultLabel.setAttribute("class", "Label");
        this.ResultLabel.classList.add("Result");
        this.ResultLabel.innerText = "Same Dates";

        this.ResultInDayLabel = document.createElement("Div");
        this.ResultInDayLabel.setAttribute("class", "Label");
        this.ResultInDayLabel.classList.add("ResultInDay");
        this.ResultInDayLabel.innerText = "";
        //              CREATING Calendar
        this.FirstCalendar = new Calendar();
        this.FirstCalendar.init();
        this.FirstCalendar.setId("_1");
        this.FirstCalendar.getButton().setAttribute("class", "btn From");


        this.SecondCalendar = new Calendar();
        this.SecondCalendar.init();
        this.SecondCalendar.setId("_2");
        this.SecondCalendar.getButton().setAttribute("class", "btn To");


        //              CONTAINER ADD ELEMENT
        this.Container.appendChild(this.btnFromLabel);
        this.FirstCalendar.appendAllAtrTo(this.Container);
        this.Container.appendChild(this.btnToLabel);
        this.SecondCalendar.appendAllAtrTo(this.Container);
        this.Container.appendChild(this.DiffLabel);
        this.Container.appendChild(this.ResultLabel);
        this.Container.appendChild(this.ResultInDayLabel);
    }
    creatingObserver() {
        this.config = {
            attribute: true,
            childList: true,
            subtree: true,
        }
        this.callback = (mutationlist, observer) => {
            for (const mutation of mutationlist) {
                this.Update();
            }
        }
        this.observer = new MutationObserver(this.callback);
    }
    Start() {
        //              Update the Result
        for (let i = 0; i < this.Calendarbtns.length; i++) {
            this.observer.observe(this.Calendarbtns[i], this.config);
        }

    }
    Update() {
        let temp = this.DateCalc.MiliToDay(this.DateCalc.DateDiff(this.FirstCalendar.getDateSelected(), this.SecondCalendar.getDateSelected()));
        this.RESULT.innerText = this.DateCalc.DaysToFullYear(temp);
        this.RESULTINDAY.innerText = temp + (temp > 1 ? " days" : " day");
    }
    destroy() {
        this.isExited = false;
        this.Container.removeChild(this.btnFromLabel);
        this.Container.removeChild(this.btnToLabel);
        this.Container.removeChild(this.DiffLabel);
        this.Container.removeChild(this.ResultLabel);
        this.Container.removeChild(this.ResultInDayLabel);
        this.FirstCalendar.removeAllAtrFrom(this.Container);
        this.SecondCalendar.removeAllAtrFrom(this.Container);
    }
};