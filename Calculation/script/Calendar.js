import CustomDay from "./DateMode/CustomDay.js";

export default class Calendar {
    constructor() {
        this.today = new CustomDay();
        this.isShowing = false;
        this.isExisted = false;
        this.dates = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
        this.Months = ["January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        this.DateSelected = new CustomDay();
    }
    init() {
        this.isExisted = true;
        const cssFile = document.createElement("link");
        cssFile.rel = "stylesheet";
        cssFile.href = "style/Calendar.css";
        document.head.appendChild(cssFile);
        // APPEND CSS FILE
        this.Container = document.querySelector(".container");
        if (this.Container === undefined) {
            this.Container = document.createElement("div");
            this.Container.setAttribute("class", "container");
            document.body.appendChild(this.Container);
        }
        // Create a background that make the user focus on the calendar

        this.BackgroundFocus = document.createElement("div");
        this.BackgroundFocus.setAttribute("class", "backgroundFocus hidden");
        document.body.appendChild(this.BackgroundFocus);

        this.CalendarBtn = document.createElement("button");
        this.CalendarBtn.setAttribute("class", "btn");

        this.Calendar = document.createElement("div");
        this.Calendar.setAttribute("class", "Calendar Calendar-Disappear-Animation hidden From");
        this.setToday();

        this.CalendarBtn.addEventListener("click", (e) => {
            if (!this.isShowing) {
                this.ToggleCalendar();
                this.isShowing = true;
                this.setCalendarDefault();
            } else {
                this.setCalendarDefault();
            }
        });

        this.createCalendar();
    }
    createCalendar() {
        this.dayBtns = [];
        //CREATE DATE CONTAINER
        this.Datecontainer = document.createElement("DIV");
        this.Datecontainer.setAttribute("class", "DateContainer");

        //CREATE CALENDAR ICON
        this.CalenderImg = document.createElement("img");
        this.CalenderImg.src = 'res/CalenderIcon.png';
        this.CalenderImg.width = 25;
        this.CalenderImg.setAttribute("class", "CalenderImg");
        this.CalendarBtn.appendChild(this.CalenderImg);
        //CREATE MONTH BUTTON
        this.createMonthbtn();

        this.linebreak = this.createLineBreak();
        this.Calendar.appendChild(this.month);
        this.Calendar.appendChild(this.linebreak);
        //CREATE DATE LABEL
        this.createDatelabel();
        //CREATE DAY BUTTON FOR CALENDAR
        this.createDayBtns();
        this.Calendar.appendChild(this.Datecontainer);
        if (this.isExisted) {
            document.addEventListener("click", () => {
                if (!this.isHover(this.Calendar)) {
                    //Close Calendar
                    this.setCalendarDefault();
                    this.isShowing = false;
                }
            });
        }
    }
    createDatelabel() {
        this.datelabel = [];
        for (let j = 0; j < 7; j++) {
            this.datelabel[j] = document.createElement("BUTTON");
            this.datelabel[j].setAttribute("class", "DateLabel");
            this.datelabel[j].innerHTML = this.dates[j];
            this.Datecontainer.appendChild(this.datelabel[j]);
        }
    }
    createDayBtns() {
        for (let j = 0; j < 42; j++) {
            this.dayBtns[j] = document.createElement("BUTTON");
        }
        let limit = +this.DayLimit(this.DateSelected.getMonth() + 1, this.DateSelected.getFullYear());
        for (let j = 0; j < 42; j++) {
            this.dayBtns[j].setAttribute("class", "Datebtn");
            this.dayBtns[j].innerHTML = (j % limit) + 1;
            if (j >= limit) {
                this.dayBtns[j].classList.add("Datebtn-overLimit");
            }
            if (j + 1 === parseInt(this.DateSelected.getDate())) {
                this.dayBtns[j].classList.add("Date-Selected");
            }
            this.dayBtns[j].addEventListener("click", (e) => {
                let tempCalendar = document.querySelectorAll(".Datebtn");
                for (let k = 0; k < tempCalendar.length; k++) {
                    tempCalendar[k].classList.remove("Date-Selected");
                }
                let value = e.target.innerText;
                this.DateSelected.setDate(value);
                e.target.classList.add("Date-Selected");
                if (e.target.classList.contains("Datebtn-overLimit")) {
                    let tempD = e.target;
                    let tempM = this.DateSelected.getMonth();
                    let tempY = this.DateSelected.getFullYear();
                    this.DateSelected.setMonth((+tempM % 12) + 1);
                    if (+tempM === 12) {
                        DateSelected.setFullYear(+tempY + 1);
                    }
                    this.destroyDatebtns();
                    this.createDayBtns();
                }
                this.UpdateData();
            });
            this.Datecontainer.appendChild(this.dayBtns[j]);
        }
    }
    createMonthbtn() {
        this.createComboBox();
        this.month = document.createElement("BUTTON");
        this.month.setAttribute("class", "Monthbtn");
        this.month.innerHTML = this.Months[parseInt(new Date().getMonth()) - 1] + " " + String(new Date().getFullYear());
        this.month.addEventListener("click", () => {});
    }
    createComboBox() {
        this.choiceContainer = document.createElement("div");
        this.choiceContainer.setAttribute("class", "choiceContainer");
        this.option = [];
        this.yearChoice = [];
        let tempM = parseInt(new Date().getMonth());
        for (let i = 0; i < this.Months.length; i++) {
            this.option[i] = document.createElement("button");
            this.option[i].setAttribute("class", "choiceBtn");
            this.option[i].innerText = this.Months[i].substring(0, 3);
            if (i === tempM) {
                this.option[i].classList.add("choiceBtn-selected");
            }
            this.option[i].addEventListener("click", (e) => {
                for (let j = 0; j < this.option.length; j++) {
                    this.option[j].classList.remove("choiceBtn-selected");
                }
                let choiceSelected = e.target;
                choiceSelected.classList.add("choiceBtn-selected");
                console.log(choiceSelected.innerText);
                let m = this.Months.findIndex((element) => {
                    return element.substring(0, 3) === choiceSelected.innerText;
                });
                this.DateSelected.setMonth(m);
                this.UpdateData();
            });
            this.choiceContainer.appendChild(this.option[i]);
        }
        this.yearChoiceContainer = document.createElement("div");
        this.yearChoiceContainer.setAttribute("class", "yearChoiceContainer");
        this.yearChoiceContainer.scrollTo(0, -30);
        let tempY = parseInt(new Date().getFullYear());
        for (let i = 0; i <= 80; i++) {
            this.yearChoice[i] = document.createElement("button");
            this.yearChoice[i].setAttribute("class", "choiceBtn");
            this.yearChoice[i].innerText = tempY - 30 + i;
            if (tempY - 30 + i === tempY) {
                this.yearChoice[i].classList.add("choiceBtn-selected");
            }
            this.yearChoice[i].addEventListener("click", (e) => {
                for (let i = 0; i < this.yearChoice.length; i++) {
                    this.yearChoice[i].classList.remove("choiceBtn-selected");
                }
                e.target.classList.add("choiceBtn-selected");
                this.DateSelected.setFullYear(e.target.innerText);
                this.UpdateData();
            });
            this.yearChoiceContainer.appendChild(this.yearChoice[i]);
        }
        // this.yearChoiceContainer.scrollTo(0, this.yearChoiceContainer.scrollHeight);
        this.Calendar.appendChild(this.choiceContainer);
        this.Calendar.appendChild(this.yearChoiceContainer);
    }
    createLineBreak() {
        return document.createElement("HR");
    }
    isHover(ELEMENT) {
        if (ELEMENT != null && ELEMENT.parentElement != null) {
            return ELEMENT.parentElement.querySelector(":hover") === ELEMENT;
        }
        return false;
    }
    destroyDatebtns() {
        for (let i = 0; i < this.dayBtns.length; i++) {
            this.Datecontainer.removeChild(this.dayBtns[i]);
        }
    }

    setCalendarDefault() {
        if (this.Calendar.classList.contains("visible")) {
            this.ToggleCalendar();
            this.isShowing = false;
        }
    };

    ToggleCalendar() {
        setTimeout(() => {
            this.Calendar.classList.toggle("hidden");
        }, 300);
        setTimeout(() => {
            this.Calendar.classList.toggle("visible");
        }, 100);
        this.BackgroundFocus.classList.toggle("hidden");
        this.BackgroundFocus.classList.toggle("visible");
        this.Calendar.classList.toggle("Calendar-Appear-Animation");
        this.Calendar.classList.toggle("Calendar-Disappear-Animation");
    }
    DayLimit(mm, yyyy) {
        let isLeapYear = false,
            daylimit;
        if (yyyy % 400 === 0 || (yyyy % 4 === 0 && yyyy % 100 != 0)) {
            isLeapYear = true;
        }
        switch (+mm) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daylimit = 31;
                break;
            case 2:
                daylimit = 28 + (isLeapYear ? 1 : 0);
                break;
            case 4:
            case 6:
            case 8:
            case 9:
            case 11:
                daylimit = 30;
                break;
        }
        return daylimit;
    }

    UpdateData() {
        this.CalendarBtn.innerText = this.DateSelected.getDateFormat();
        this.month.innerText = this.Months[+this.DateSelected.getMonth()] + " " + this.DateSelected.getFullYear();
    };
    setToday() {
        let dd = String(this.today.getDate()).padStart(2, 0);
        let mm = String(this.today.getMonth()).padStart(2, 0);
        let yyyy = String(this.today.getFullYear()).padStart(4, 0);
        this.DateSelected.setAllAttr(dd, mm, yyyy);
        this.DateSelected.setSeconds(this.today.getHours(), this.today.getMinutes(), 0);
        this.CalendarBtn.innerText = this.DateSelected.getDateFormat();
    }
    setId(id) {
        this.Calendar.setAttribute("id", id);
    }
    getButton() {
        return this.CalendarBtn;
    }
    getDateSelected() {
        return this.DateSelected;
    }
    appendAllAtrTo(e) {
        e.appendChild(this.CalendarBtn);
        e.appendChild(this.Calendar);
    }
    removeAllAtrFrom(e) {
        this.isExisted = false;
        e.removeChild(this.CalendarBtn);
        e.removeChild(this.Calendar);
    }
}