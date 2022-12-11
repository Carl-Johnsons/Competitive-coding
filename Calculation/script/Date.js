// MENU FUNCTIONALITY
let MenuList = document.querySelector(".MenuList");
let MenuIcon = document.querySelector(".MenuIcon");
let Menubtns = document.querySelectorAll(".Menubtn");
MenuList.classList.add("MenuListMoveOut");

// DATE FUNCTIONALITY
let dates = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
let Months = ["January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
let SelectedDay = "";
let SelectedMonth = "";
let SelectedYear = "";

let CalendarBtns = document.querySelectorAll(".btn");

let CALENDAR = document.querySelectorAll(".Calendar");
for (i = 0; i < CalendarBtns.length; i++) {
    let today = new Date();
    let dd = String(today.getDate()).padStart(2, 0);
    let mm = String(today.getMonth()).padStart(2, 0);
    let yyyy = String(today.getFullYear());
    let date = dd + "/" + mm + "/" + yyyy;
    CalendarBtns[i].innerText = date;
}
// CalendarBtns[0].addEventListener("click", () => {
//     ToggleCalendar(0);
// });
// CalendarBtns[1].addEventListener("click", () => {
//     ToggleCalendar(1);
// });
for (i = 0; i < CalendarBtns.length; i++) {
    CalendarBtns[i].addEventListener("click", (e) => {
        let temp = e.target.getAttribute("class");
        let pos = temp.substring(4, temp.length - 1);
        if (pos === "From")
            ToggleCalendar(0);
        else if (pos === "To")
            ToggleCalendar(1);
    });
}



function ToggleCalendar(i) {
    CALENDAR[i].classList.toggle("hidden");
    CALENDAR[i].classList.toggle("visible");
}

let date, month, year, Datecontainer;
let day = [];
createCalendar(0);
createCalendar(1);

function createCalendar(i) {

    //CREATE DATE CONTAINER
    Datecontainer = document.createElement("DIV");
    Datecontainer.setAttribute("class", "DateContainer");

    //CREATE MONTH BUTTON
    month = document.createElement("BUTTON");
    month.setAttribute("class", "Monthbtn");
    console.log(new Date().getMonth);
    month.innerHTML = Months[parseInt(new Date().getMonth()) - 1] + " " + String(new Date().getFullYear());
    CALENDAR[i].appendChild(month);
    CALENDAR[i].appendChild(createLineBreak());
    //CREATE DATE 
    for (j = 0; j < 7; j++) {
        date = document.createElement("BUTTON");
        date.setAttribute("class", "DateLabel");
        date.innerHTML = dates[j];
        Datecontainer.appendChild(date);
    }
    //CREATE DAY BUTTON FOR CALENDAR
    for (j = 0; j < 42; j++) {
        day[j] = document.createElement("BUTTON");
        day[j].setAttribute("class", "Datebtn");
        day[j].innerHTML = (j % 30) + 1;
        day[j].addEventListener("click", (e) => {
            ToggleCalendar(i);
            let value = e.target.innerText;
            let dd = String(value).padStart(2, 0);
            day[j].classList.add("Date-Selected");
            CalendarBtns[i].innerHTML = dd;
        });
        Datecontainer.appendChild(day[j]);
    }
    CALENDAR[i].appendChild(Datecontainer);
}


function createLineBreak() {
    let linebreak = document.createElement("HR");
    return linebreak;
}



//CUSTOM COMBO BOX, Not understand much sad
var x, i, j, l, ll, selElmnt, a, b, c;
let isClicked = 0;
/*look for any elements with the class "custom-select":*/
x = document.getElementsByClassName("custom-select");
l = x.length;
for (i = 0; i < l; i++) {
    selElmnt = x[i].getElementsByTagName("select")[0];
    ll = selElmnt.length;
    /*for each element, create a new DIV that will act as the selected item:*/
    a = document.createElement("DIV");
    a.setAttribute("class", "select-selected");
    a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
    x[i].appendChild(a);
    /*for each element, create a new DIV that will contain the option list:*/
    b = document.createElement("DIV");
    b.setAttribute("class", "select-items select-hide");
    for (j = 1; j < ll; j++) {
        /*for each option in the original select element,
        create a new DIV that will act as an option item:*/
        c = document.createElement("DIV");
        c.innerHTML = selElmnt.options[j].innerHTML;
        c.addEventListener("click", function(e) {
            /*when an item is clicked, update the original select box,
            and the selected item:*/
            var y, i, k, s, h, sl, yl;
            s = this.parentNode.parentNode.getElementsByTagName("select")[0];
            sl = s.length;
            h = this.parentNode.previousSibling;
            for (i = 0; i < sl; i++) {
                if (s.options[i].innerHTML == this.innerHTML) {
                    s.selectedIndex = i;
                    h.innerHTML = this.innerHTML;
                    y = this.parentNode.getElementsByClassName("same-as-selected");
                    yl = y.length;
                    for (k = 0; k < yl; k++) {
                        y[k].removeAttribute("class");
                    }
                    this.setAttribute("class", "same-as-selected");
                    break;
                }
            }
            h.click();
        });
        b.appendChild(c);
    }
    x[i].appendChild(b);
    a.addEventListener("click", function(e) {
        /*when the select box is clicked, close any other select boxes,
        and open/close the current select box:*/
        e.stopPropagation();
        closeAllSelect(this);
        this.nextSibling.classList.toggle("select-hide");
        this.classList.toggle("select-arrow-active");
    });
}

function closeAllSelect(elmnt) {
    console.log(document.getElementsByTagName("select")[0].selectedIndex);
    /*a function that will close all select boxes in the document,
    except the current select box:*/
    var x, y, i, xl, yl, arrNo = [];
    x = document.getElementsByClassName("select-items");
    y = document.getElementsByClassName("select-selected");
    xl = x.length;
    yl = y.length;
    for (i = 0; i < yl; i++) {
        if (elmnt == y[i]) {
            arrNo.push(i)
        } else {
            y[i].classList.remove("select-arrow-active");
        }
    }
    for (i = 0; i < xl; i++) {
        if (arrNo.indexOf(i)) {
            x[i].classList.add("select-hide");
        }
    }
}
/*if the user clicks anywhere outside the select box,
then close all select boxes:*/
document.addEventListener("click", closeAllSelect);
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