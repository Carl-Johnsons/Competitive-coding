import CustomDay from "./CustomDay.js"
export default class DateDiffMode {

    constructor() {
        const cssFile = document.createElement("link");
        cssFile.rel = "stylesheet";
        cssFile.href = "style/DateDiffMode.css";
        document.head.appendChild(cssFile);
        this.init();
    }
    init() {
        const dates = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
        const Months = ["January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
        this.Container = document.querySelector(".container");
        if (this.Container === undefined) {
            this.Container = document.createElement("Div");
            this.Container.setAttribute("class", "container");
            document.body.appendChild(this.Container);
        }
        this.btnFromLabel = document.createElement("Div");
        this.btnFromLabel.setAttribute("class", "Label");
        this.btnFromLabel.innerText = "From";
        this.btnFrom = document.createElement("button");
        this.btnFrom.setAttribute("class", "btn From");
        this.btnToLabel = document.createElement("Div");
        this.btnToLabel.setAttribute("class", "Label");
        this.btnToLabel.innerText = "To";
        this.btnTo = document.createElement("button");
        this.btnTo.setAttribute("class", "btn To");
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
        this.ResultInDayLabel.innerText = "lol";
        this.FirstCalendar = document.createElement("Div");
        this.FirstCalendar.setAttribute("class", "Calendar Calendar-Disappear-Animation hidden From");
        this.FirstCalendar.setAttribute("id", "_1");
        this.SecondCalendar = document.createElement("Div");
        this.SecondCalendar.setAttribute("class", "Calendar Calendar-Disappear-Animation hidden To");
        this.SecondCalendar.setAttribute("id", "_2");
        //              CONTAINER ADD ELEMENT
        this.Container.appendChild(this.btnFromLabel);
        this.Container.appendChild(this.btnFrom);
        this.Container.appendChild(this.btnToLabel);
        this.Container.appendChild(this.btnTo);
        this.Container.appendChild(this.DiffLabel);
        this.Container.appendChild(this.ResultLabel);
        this.Container.appendChild(this.ResultInDayLabel);
        this.Container.appendChild(this.FirstCalendar);
        this.Container.appendChild(this.SecondCalendar);

        let CalendarBtns = document.querySelectorAll(".btn");
        let CALENDAR = document.querySelectorAll(".Calendar");
        let RESULTINDAY = document.querySelector(".ResultInDay");
        let RESULT = document.querySelector(".Result");
        let today = new Date();
        // STATE
        let isShowCalendar = false;
        // DATA
        let DateSelected = [];
        let DateCalc = new CustomDay();
        DateSelected[0] = new CustomDay();
        DateSelected[1] = new CustomDay();
        for (let i = 0; i < CalendarBtns.length; i++) {
            let dd = String(today.getDate()).padStart(2, 0);
            let mm = String(today.getMonth()).padStart(2, 0);
            let yyyy = String(today.getFullYear()).padStart(4, 0);
            DateSelected[i].setAllAttr(dd, mm, yyyy);
            CalendarBtns[i].innerText = DateSelected[i].getDateFormat();
        }

        for (let i = 0; i < CalendarBtns.length; i++) {
            CalendarBtns[i].addEventListener("click", (e) => {
                let temp = e.target.getAttribute("class");
                setCalendarDefault();
                if (!isShowCalendar) {
                    if (e.target.classList.contains("From"))
                        ToggleCalendar(i);
                    else if (e.target.classList.contains("To"))
                        ToggleCalendar(i);
                    isShowCalendar = true;
                    setCalendarDefault();
                } else {
                    setCalendarDefault();
                }
            });
        }

        function ToggleCalendar(i) {

            setTimeout(() => {
                CALENDAR[i].classList.toggle("hidden");
            }, 300);
            setTimeout(() => {
                CALENDAR[i].classList.toggle("visible");
            }, 100);
            CALENDAR[i].classList.toggle("Calendar-Appear-Animation");
            CALENDAR[i].classList.toggle("Calendar-Disappear-Animation");
        }

        function setCalendarDefault() {
            for (let i = 0; i < CALENDAR.length; i++) {
                if (CALENDAR[i].classList.contains("visible")) {
                    ToggleCalendar(i);
                }
            }
            isShowCalendar = false;
        };

        let date, month = [],
            year, Datecontainer = [],
            CalenderImg, linebreak = [];
        let day = [];
        createCalendar(0);
        createCalendar(1);

        function createCalendar(i) {
            //CREATE DATE CONTAINER
            Datecontainer[i] = document.createElement("DIV");
            Datecontainer[i].setAttribute("class", "DateContainer");

            //CREATE CALENDAR ICON
            CalenderImg = document.createElement("img");
            CalenderImg.src = 'res/CalenderIcon.png';
            CalenderImg.width = 25;
            CalenderImg.setAttribute("class", "CalenderImg");
            CalendarBtns[i].appendChild(CalenderImg);
            //CREATE MONTH BUTTON
            month[i] = document.createElement("BUTTON");
            month[i].setAttribute("class", "Monthbtn");
            month[i].innerHTML = Months[parseInt(new Date().getMonth()) - 1] + " " + String(new Date().getFullYear());

            linebreak[i] = createLineBreak();
            CALENDAR[i].appendChild(month[i]);
            CALENDAR[i].appendChild(linebreak[i]);
            //CREATE DATE 
            for (let j = 0; j < 7; j++) {
                date = document.createElement("BUTTON");
                date.setAttribute("class", "DateLabel");
                date.innerHTML = dates[j];
                Datecontainer[i].appendChild(date);
            }
            //CREATE DAY BUTTON FOR CALENDAR
            for (let j = 0; j < 42; j++) {
                day[j] = document.createElement("BUTTON");
            }
            let limit = +DayLimit(DateSelected[i].getMonth() + 1, DateSelected[i].getFullYear());
            for (let j = 0; j < 42; j++) {
                day[j].setAttribute("class", "Datebtn");
                day[j].innerHTML = (j % limit) + 1;
                if (j >= limit) {
                    day[j].classList.add("Datebtn-overLimit");
                }
                day[j].addEventListener("click", (e) => {
                    let tempCalendar = document.querySelectorAll(".Datebtn");
                    for (let k = 0; k < tempCalendar.length; k++) {
                        tempCalendar[k].classList.remove("Date-Selected");
                    }
                    let value = e.target.innerText;
                    DateSelected[i].setDate(value);
                    e.target.classList.add("Date-Selected");
                    if (e.target.classList.contains("Datebtn-overLimit")) {
                        let tempD = e.target;
                        let tempM = DateSelected[i].getMonth();
                        let tempY = DateSelected[i].getFullYear();
                        DateSelected[i].setMonth((+tempM % 12) + 1);
                        if (+tempM === 12) {
                            DateSelected[i].setFullYear(+tempY + 1);
                        }
                        CALENDAR[i].removeChild(Datecontainer[i]);
                        CALENDAR[i].removeChild(month[i]);
                        CALENDAR[i].removeChild(linebreak[i]);
                        createCalendar(i);
                    }
                    UpdateData();
                });
                Datecontainer[i].appendChild(day[j]);
            }
            CALENDAR[i].appendChild(Datecontainer[i]);

        }

        function createLineBreak() {
            let linebreak = document.createElement("HR");
            return linebreak;
        }

        function DayLimit(mm, yyyy) {
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

        function UpdateData() {
            for (let i = 0; i < CalendarBtns.length; i++) {
                CalendarBtns[i].innerText = DateSelected[i].getDateFormat();
                month[i].innerText = Months[+DateSelected[i].getMonth()] + " " + DateSelected[i].getFullYear();
            }
            let temp = DateCalc.DateDiff(DateSelected[0], DateSelected[1]);
            RESULT.innerText = DateCalc.DaysToFullYear(DateCalc.res);
            RESULTINDAY.innerText = temp + (temp > 1 ? " days" : " day");
        };
    }

    destroy() {
        this.Container.removeChild(this.btnFrom);
        this.Container.removeChild(this.btnFromLabel);
        this.Container.removeChild(this.btnToLabel);
        this.Container.removeChild(this.btnTo);
        this.Container.removeChild(this.DiffLabel);
        this.Container.removeChild(this.ResultLabel);
        this.Container.removeChild(this.ResultInDayLabel);
        this.Container.removeChild(this.FirstCalendar);
        this.Container.removeChild(this.SecondCalendar);
    }
};