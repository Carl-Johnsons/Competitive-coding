// MENU FUNCTIONALITY
let MenuList = document.querySelector(".MenuList");
let MenuIcon = document.querySelector(".MenuIcon");
let Menubtns = document.querySelectorAll(".Menubtn");
MenuList.classList.add("MenuListMoveOut");

// PROGRAMER MODE FUNCTIONALITY
// TUTORIAL CONTAINER
let tutorialContainer = document.querySelector(".tips");
let TurCloseBtn = document.querySelector(".Turtial-close");
// CONTAINER
let MODEs = ["HEX", "DEC", "OCT", "BIN"];
let currentMODE = "DEC";
let HEXbtns = document.querySelectorAll(".HEX");
let DECbtns = document.querySelectorAll(".DEC");
let OCTbtns = document.querySelectorAll(".OCT");
let BINbtns = document.querySelectorAll(".BIN");
let numbers = document.querySelectorAll(".number");
let MODEbtns = document.querySelectorAll(".ModeBtn");
let btns = document.querySelectorAll(".btn");
// TEXT
let textNumber = document.querySelector("#textNumber");
let saveNumber = document.querySelector("#saveNumber");
// OPERATOR
let del = document.querySelector(".delete");
let clear = document.querySelector(".clear");
let Add = document.querySelector(".add");
let Sub = document.querySelector(".sub");
let Mul = document.querySelector(".mul");
let Div = document.querySelector(".div");
let Mod = document.querySelector(".mod");
let Equal = document.querySelector(".equal");
//HANDLING DATA
let OPERATOR;
let firstValue;
let secondValue;
let RESULT;
//STATE
let isShowingResult = false;
let isOPpressed = false;
let isClickedChangeModeTooMuch = 0;
let isUndefined = false;
let isKeyPressed = false;

// INITIAL MODE
ChangeMODE(currentMODE);


for (i = 0; i < numbers.length; i++) {
    numbers[i].addEventListener("click", (e) => {
        let value = e.target.innerText;
        addToResult(value);
    });

}
del.addEventListener("click", () => {
    Delete();
});
clear.addEventListener("click", () => {
    ClrAll();
});
TurCloseBtn.addEventListener("click", () => {
    CloseHintAnimation();

});

function addToResult(value) {
    if (isShowingResult) {
        textNumber.innerText = "";
        isShowingResult = false;
    }
    if (textNumber.innerText === "0" || isOPpressed) {
        textNumber.innerText = "";
    }
    let limit = 100;
    switch (currentMODE) {
        case "HEX":
            limit = 13;
            break;
        case "DEC":
            limit = 15;
            break;
        case "OCT":
            limit = 17;
            break;
        case "BIN":
            limit = 53;
            break;
    }
    if (textNumber.innerText.length < limit) {
        textNumber.innerText += value;
    }
    if (isKeyPressed) {
        for (i = 0; i < numbers.length; i++) {
            if (numbers[i].innerText == value) {
                ButtonActive(numbers[i]);
                break;
            }
        }
        isKeyPressed = false;
    }

    UpdateData();
}
Add.addEventListener("click", () => {
    op("+");
});
Sub.addEventListener("click", () => {
    op("-");
});
Mul.addEventListener("click", () => {
    op("x");
});
Div.addEventListener("click", () => {
    op("/");
});
Mod.addEventListener("click", () => {
    op("%");
});
Equal.addEventListener("click", () => {
    EqualOP();
});

function op(op) {
    firstValue = +textNumber.innerText;
    textNumber.innerText += " " + op;
    OPERATOR = op;
    if (isKeyPressed) {
        switch (op) {
            case "+":
                ButtonActive(Add);
                break;
            case "-":
                ButtonActive(Sub);
                break;
            case "x":
                ButtonActive(Mul);
                break;
            case "/":
                ButtonActive(Div);
                break;
            case "%":
                ButtonActive(Mod);
                break;
        }
        isKeyPressed = false;
    }
    opPressedAnimation();
    ResetData();
    isShowingResult = false;
}

function EqualOP() {
    if (isShowingResult) {
        textNumber.innerText = RESULT;
    } else {
        secondValue = +textNumber.innerText;
        RESULT = calculate();
        saveNumber.innerText += (" " + secondValue + " = ");
        textNumber.innerText = RESULT;
        isShowingResult = true;
    }
    opPressedAnimation();
    UpdateData();
}

function calculate() {
    let result;
    switch (OPERATOR) {
        case "+":
            result = firstValue + secondValue;
            break;
        case "-":
            result = firstValue - secondValue;
            break;
        case "x":
            result = firstValue * secondValue;
            break;
        case "/":
            if (secondValue != 0)
                result = firstValue / secondValue;
            else {
                result = "undefined";
                isUndefined = true;
            }
            break;
        case "%":
            if (secondValue != 0)
                result = firstValue % secondValue;
            else {
                result = "undefined";
                isUndefined = true;
            }
            break;
    }
    return result;
}

function Delete() {
    if (textNumber.innerText.length > 1) {
        let temp = textNumber.innerText.substring(0, textNumber.innerText.length - 1);
        textNumber.innerText = temp;
    } else {
        textNumber.innerText = 0;
    }
    UpdateData();
}

function ClrAll() {
    OPERATOR = null;
    firstValue = null;
    secondValue = null;
    textNumber.innerText = 0;
    saveNumber.innerText = "";
    isShowingResult = false;
    isOPpressed = false;
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

function UpdateData() {
    MODEbtns[0].innerText = convertTo(textNumber.innerText, "HEX");
    MODEbtns[1].innerText = convertToDec(textNumber.innerText);
    MODEbtns[2].innerText = convertTo(textNumber.innerText, "OCT");
    MODEbtns[3].innerText = convertTo(textNumber.innerText, "BIN");
    console.log(textNumber.innerText.length);
}

function ResetData() {
    saveNumber.innerText = textNumber.innerText;
    textNumber.innerText = 0;
}
//ANIMATION
function ButtonActive(button) {
    button.classList.toggle("active");
}

function AllButtonInActive() {
    for (i = 0; i < btns.length; i++) {
        btns[i].classList.remove("active");
    }
}


function ShowHintAnimation() {
    tutorialContainer.classList.remove("Tutorial-CloseHint");
    tutorialContainer.classList.add("Tutorial-ShowHint");
}

function CloseHintAnimation() {
    tutorialContainer.classList.remove("Tutorial-ShowHint");
    tutorialContainer.classList.add("Tutorial-CloseHint");
}

function opPressedAnimation() {
    if (textNumber.classList.contains("moveUp")) {
        textNumber.style.animation = 'none';
        textNumber.offsetHeight;
        textNumber.style.animation = null;
        saveNumber.style.animation = 'none';
        saveNumber.offsetHeight;
        saveNumber.style.animation = null;
    }
    textNumber.classList.add("moveUp");
    saveNumber.classList.add("smaller");
}


// MODE CHANGING
for (i = 0; i < MODEbtns.length; i++) {
    MODEbtns[i].addEventListener("click", (e) => {
        isClickedChangeModeTooMuch++;
        currentMODE = e.target.getAttribute("value").substring(0, 3);
        console.log(currentMODE);
        ChangeMODE(currentMODE);
        if (isClickedChangeModeTooMuch === 5) {
            ShowHintAnimation();
        }
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



//KEY BINDING
document.onkeydown = (e) => {
    let alphabet = String.fromCharCode(e.which);
    let isAlt = !!e.altKey;
    let isShift = !!e.shiftKey;
    let isAllowed = false;
    console.log(e.which);
    //MODE CHANGING
    if (isAlt) {
        switch (e.which) {
            case 72: //H
                ChangeMODE("HEX");
                break;
            case 68: //D
                ChangeMODE("DEC");
                break;
            case 79: //O
                ChangeMODE("OCT");
                break;
            case 66: //B
                ChangeMODE("BIN");
                break;
        }
    } else if (isShift) { //OPERATOR
        switch (e.which) {
            case 187:
                op("+");
                break;
            case 56:
                op("x");
                break;
            case 53:
                op("%");
                break;
        }
    } else if (e.which === 189) {
        op("-");
    } else if (e.which === 191) {
        op("/");
    } else if (e.which === 187) {
        EqualOP();
    } else if (e.which === 8) { //BackSpace
        Delete();
        ButtonActive(del);
    } else if (e.which === 27) { //Esc
        ClrAll();
        ButtonActive(clear);
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
    isKeyPressed = true;
};
document.onkeyup = (e) => {
    AllButtonInActive();
};
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