import CustomDay from "./CustomDay.js";
export default class AddSubMode {
    constructor() {
        this.isExited = false;
    }
    init() {
        const cssFile = document.createElement("link");
        cssFile.rel = "stylesheet";
        cssFile.href = "style/DateMode/AddSubMode.js";
        document.head.appendChild(cssFile);
        this.isExited = true;

        this.Container = document.querySelector(".container");

        this.Frombtn = document.createElement("button");
        this.Frombtn.setAttribute("class", "btn From");
        //CALENDAR DECLARE
        this.CALENDAR = document.createElement("div");
        this.CALENDAR.setAttribute("class", "Calendar Calendar-Disappear-Animation hidden From");
        this.CALENDAR.setAttribute("id", "_1");
        //Data
        let DateCalc = new CustomDay();
        let FromDate = new CustomDay();

        let today = new Date();
        let dd = String(today.getDate()).padStart(2, 0);
        let mm = String(today.getMonth()).padStart(2, 0);
        let yyyy = String(today.getFullYear()).padStart(4, 0);
        FromDate.setAllAttr(dd, mm, yyyy);
        FromDate.innerText = FromDate.getDateFormat();


        this.Frombtn.addEventListener("click", (e) => {
            setCalendarDefault();
            if (!isShowCalendar) {
                if (e.target.classList.contains("From"))
                    ToggleCalendar();
                setCalendarDefault();
            } else {
                setCalendarDefault();
            }
        });

        function ToggleCalendar() {

            setTimeout(() => {
                CALENDAR.classList.toggle("hidden");
            }, 300);
            setTimeout(() => {
                CALENDAR.classList.toggle("visible");
            }, 100);
            CALENDAR.classList.toggle("Calendar-Appear-Animation");
            CALENDAR.classList.toggle("Calendar-Disappear-Animation");
        }

        function setCalendarDefault() {
            if (CALENDAR.classList.contains("visible")) {
                ToggleCalendar();
            }
            isShowCalendar = false;
        };

        let date, month = [],
            year, Datecontainer,
            CalenderImg, linebreak;
        let day = [];
        createCalendar();

        function createCalendar() {
            //CREATE DATE CONTAINER
            Datecontainer = document.createElement("DIV");
            Datecontainer.setAttribute("class", "DateContainer");

            //CREATE CALENDAR ICON
            CalenderImg = document.createElement("img");
            CalenderImg.src = 'res/CalenderIcon.png';
            CalenderImg.width = 25;
            CalenderImg.setAttribute("class", "CalenderImg");
            this.Frombtn.appendChild(CalenderImg);
            //CREATE MONTH BUTTON
            month = document.createElement("BUTTON");
            month.setAttribute("class", "Monthbtn");
            month.innerHTML = Months[parseInt(new Date().getMonth()) - 1] + " " + String(new Date().getFullYear());

            linebreak = createLineBreak();
            CALENDAR.appendChild(month);
            CALENDAR.appendChild(linebreak);
            //CREATE DATE 
            for (let j = 0; j < 7; j++) {
                date = document.createElement("BUTTON");
                date.setAttribute("class", "DateLabel");
                date.innerHTML = dates[j];
                Datecontainer.appendChild(date);
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
                Datecontainer.appendChild(day[j]);
            }
            CALENDAR.appendChild(Datecontainer[i]);

        }

        function createLineBreak() {
            let linebreak = document.createElement("HR");
            return linebreak;
        }


        // Container 
        this.Container.appendChild(this.Frombtn);
    }
    destroy() {
        this.isExited = false;
    }
}