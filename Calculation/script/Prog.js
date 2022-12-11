// MENU FUNCTIONALITY
let MenuList = document.querySelector(".MenuList");
let MenuIcon = document.querySelector(".MenuIcon");
let Menubtns = document.querySelectorAll(".Menubtn");
MenuList.classList.add("MenuListMoveOut");

// PROGRAMER MODE FUNCTIONALITY
let MODEs = ["HEX", "DEC", "OCT", "BIN"];
let currentMODE = "DEC";
let HEXbtns = document.querySelectorAll(".HEX");
let DECbtns = document.querySelectorAll(".DEC");
let OCTbtns = document.querySelectorAll(".OCT");
let BINbtns = document.querySelectorAll(".BIN");
let numbers = document.querySelectorAll(".number");
let MODEbtns = document.querySelectorAll(".ModeBtn");
let del = document.querySelector(".delete");
// TEXT
let textNumber = document.querySelector("#textNumber");
let saveNumber = document.querySelector("#saveNumber");
//STATE

let isShowingResult = false;
let isOPpressed = false;

// INITIAL MODE
ChangeMODE(currentMODE);


for (i = 0; i < numbers.length; i++) {
    numbers[i].addEventListener("click", (e) => {
        let value = e.target.innerText;
        addToResult(value);
    });
}

function addToResult(value) {
    if (textNumber.innerText === "0" || isOPpressed) {
        textNumber.innerText = "";
    }
    if (textNumber.innerText.length < 19) {
        textNumber.innerText += value;
    }
    UpdateData();
}
del.addEventListener("click", () => {
    Delete();
});

function Delete() {
    if (textNumber.innerText.length > 1) {
        let temp = textNumber.innerText.substring(0, textNumber.innerText.length - 1);
        textNumber.innerText = temp;
    } else {
        textNumber.innerText = 0;
    }
    UpdateData();
}

function convertToDec(value) {
    let dec = 0;
    let mul;
    switch (currentMODE) {
        case "HEX":
            mul = 16;
            break;
        case "DEC":
            return value;
        case "OCT":
            mul = 8;
            break;
        case "BIN":
            mul = 2;
            break;
    }
    for (i = 0; i < value.length; i++) {
        let num;
        if (value[i] >= '0' && value[i] <= '9')
            num = +value[i];
        else {
            num = +(value[i].charCodeAt() - 55);
        }
        dec += num * Math.pow(mul, value.length - 1 - i);
    }
    return dec;
}

function convertTo(value, MODE) {
    let division;
    switch (MODE) {
        case "HEX":
            division = 16;
            break;
        case "OCT":
            division = 8;
            break;
        case "BIN":
            division = 2;
            break;
        default:
            return;
    }
    let res = "";
    let DecValue = +convertToDec(value);
    if (DecValue != 0) {
        while (DecValue > 0) {
            let temp = DecValue % division;
            if (temp >= 10) {
                temp = String.fromCharCode(temp + 55);
            }
            res += temp;
            DecValue /= division;
            DecValue = Math.floor(DecValue);
        }
        res = res.split("").reverse().join("");
    } else {
        res = DecValue;
    }
    return res;
}



// MODE CHANGING
for (i = 0; i < MODEbtns.length; i++) {
    MODEbtns[i].addEventListener("click", (e) => {
        currentMODE = e.target.getAttribute("value").substring(0, 3);
        console.log(currentMODE);
        ChangeMODE(currentMODE);
    });
}

function ChangeMODE(m) {
    textNumber.innerText = 0;
    disableAllButton();
    switch (m) {
        case "HEX":
            enableButton(HEXbtns);
            break;
        case "DEC":
            enableButton(DECbtns);
            break;
        case "OCT":
            enableButton(OCTbtns);
            break;
        case "BIN":
            enableButton(BINbtns);
            break;
    }
    UpdateData();
}

function disableAllButton() {
    for (i = 0; i < numbers.length; i++) {
        numbers[i].classList.add("disable-button");
    }
}

function enableButton(Mbtns) {
    for (i = 0; i < Mbtns.length; i++) {
        Mbtns[i].classList.remove("disable-button");
    }
    for (i = 0; i < MODEbtns.length; i++) {
        MODEbtns[i].classList.remove("ModeBtn-StayActive");
    }
    switch (Mbtns.length) {
        case 16:
            MODEbtns[0].classList.add("ModeBtn-StayActive");
            break;
        case 10:
            MODEbtns[1].classList.add("ModeBtn-StayActive");
            break;
        case 8:
            MODEbtns[2].classList.add("ModeBtn-StayActive");
            break;
        case 2:
            MODEbtns[3].classList.add("ModeBtn-StayActive");
            break;
    }
}

function UpdateData() {
    MODEbtns[0].innerText = convertTo(textNumber.innerText, "HEX");
    MODEbtns[1].innerText = convertToDec(textNumber.innerText);
    MODEbtns[2].innerText = convertTo(textNumber.innerText, "OCT");
    MODEbtns[3].innerText = convertTo(textNumber.innerText, "BIN");

}


//KEY BINDING
document.onkeydown = (e) => {
    let alphabet = String.fromCharCode(e.which);
    console.log(e.which);
    let isAllowed = false;
    if (e.which === 8) {
        //DELETE
        Delete();
    } else if (alphabet >= '0' && alphabet <= '9' && currentMODE === "DEC") {
        isAllowed = true;
    } else if (alphabet >= '0' && alphabet <= '7' && currentMODE === "OCT") {
        isAllowed = true;
    } else if (alphabet >= '0' && alphabet <= '1' && currentMODE === "BIN") {
        isAllowed = true;
    } else if ((alphabet >= '0' && alphabet <= '9' || alphabet >= 'A' && alphabet <= 'F') && currentMODE === "HEX") {
        isAllowed = true;
    }
    if (isAllowed) {
        addToResult(alphabet);
    }
}

//MENU FUNCTIONALITY
//DEFAULT MODE: PROG
setDefaultMode();
// hover
MenuIcon.addEventListener("mouseenter", () => {
    MenuList.classList.remove("MenuListMoveOut");
    if (MenuList.classList.contains("MenuListMoveIn")) {
        MenuList.style.animation = 'none';
        MenuList.offsetHeight;
        MenuList.style.animation = null;
    }
    MenuList.classList.add("MenuListMoveIn");
});
// !Hover
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
    Menubtns[2].classList.add("MenuListStayActive");
}