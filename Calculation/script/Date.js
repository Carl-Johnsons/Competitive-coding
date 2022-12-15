import CustomDay from "./CustomDay.js"

// MENU FUNCTIONALITY
let MenuList = document.querySelector(".MenuList");
let MenuIcon = document.querySelector(".MenuIcon");
let Menubtns = document.querySelectorAll(".Menubtn");
MenuList.classList.add("MenuListMoveOut");

// DATE FUNCTIONALITY
const dates = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
const Months = ["January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
let CalendarBtns = document.querySelectorAll(".btn");
let Container = document.querySelector(".container");
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
        let pos = temp.substring(4, temp.length - 1);
        setCalendarDefault();
        if (!isShowCalendar) {
            if (pos === "From")
                ToggleCalendar(i);
            else if (pos === "To")
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
    console.log({ limit });
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
            console.log("DATE = " + DateSelected[i].getDate());
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
            console.log({ DateSelected });
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
    console.log({ mm, yyyy });
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
document.onmousedown = (e) => {};

function UpdateData() {
    for (let i = 0; i < CalendarBtns.length; i++) {
        CalendarBtns[i].innerText = DateSelected[i].getDateFormat();
        month[i].innerText = Months[+DateSelected[i].getMonth()] + " " + DateSelected[i].getFullYear();
    }
    let temp = DateCalc.DateDiff(DateSelected[0], DateSelected[1]);
    RESULTINDAY.innerText = temp + (temp > 1 ? " days" : " day");

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