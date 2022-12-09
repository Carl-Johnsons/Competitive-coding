// MENU FUNCTIONALITY
let MenuList = document.querySelector(".MenuList");
let MenuIcon = document.querySelector(".MenuIcon");
let Menubtns = document.querySelectorAll(".Menubtn");

// COMPUTER FUNCTIONALITY
const numbers = document.querySelectorAll(".number");
let Add = document.querySelector(".add");
let Sub = document.querySelector(".sub");
let Mul = document.querySelector(".mul");
let Div = document.querySelector(".div");
let Equal = document.querySelector(".equal");
let Clear = document.querySelector(".clear");
let Opposite = document.querySelector(".opposite");
let Modulo = document.querySelector(".modulo");
const textnum = document.getElementById("textNumber");

const result = document.querySelector("#textNumber");
const saveNum = document.querySelector("#saveNumber");
let firstValue = "";
let secondValue = "";
let OPERATOR = "";
let showResult = 0;
let isConstract = 0;
let isOpPressed = 0;
let isUndefined = 0;



for (let i = 0; i < numbers.length; i++) {
    numbers[i].addEventListener('click', (e) => {
        let attr = e.target.getAttribute("value");
        addToNumber(attr);
    });
}

Add.addEventListener('click', () => {
    op("+");
});
Sub.addEventListener('click', () => {
    op("-");
});
Mul.addEventListener('click', () => {
    op("x");
});
Div.addEventListener('click', () => {
    op("/");
});
Equal.addEventListener('click', () => {
    equal();
});
Modulo.addEventListener('click', () => {
    op("%");
});

Clear.addEventListener('click', () => {
    clr();
});
Opposite.addEventListener('click', () => {
    constract();
});

function addToNumber(value) {
    if (isUndefined === 0) {
        if ((result.innerText === "0" || showResult === 1)) {
            if (isOpPressed === 0 && showResult === 1) {
                saveNum.innerText = "Ans = " + result.innerHTML;
                animation();
            }
            result.innerText = "";
            showResult = 0;
        }
        result.innerHTML += value;
    } else {
        shake_animation();
    }
}

function op(operation) {
    if (isUndefined === 0) {
        if (isOpPressed === 0) {
            isOpPressed = 1;
            let str = result.innerHTML;
            if (str.charAt(str.length - 1) === '+' || str.charAt(str.length - 1) === "-" || str.charAt(str.length - 1) === "x" || str.charAt(str.length - 1) === "/") {
                result.innerHTML = str.substring(0, length - 1);
                result.innerHTML += (" " + operation);
                firstValue = str.substring(0, length - 2);

            } else {
                firstValue = str;
                result.innerHTML += (" " + operation);
            }
            OPERATOR = operation;

        } else {
            secondValue = result.innerText;
            firstValue = +firstValue;
            secondValue = +secondValue;
            if (secondValue != 0) {
                handle2op(operation);
            }
        }
        animation();
        reset_value();
    } else {
        shake_animation();
    }
}

function clr() {
    saveNum.innerHTML = "";
    result.innerHTML = "0";
    firstValue = "";
    secondValue = "";
    showResult = 0;
    isConstract = 0;
    isOpPressed = 0;
    isUndefined = 0;
    Clear.classList.remove("delayAC");
}

function equal() {
    if (isUndefined === 0) {
        let str = document.getElementById("saveNumber").innerText;
        if (str.substring(0, 3) === "Ans" || saveNum.innerText === "" || isOpPressed != 1) {
            saveNum.innerText = "";
            saveNum.innerText = result.innerText + " = ";
        } else {
            if (showResult != 1) {
                secondValue = document.getElementById("textNumber").innerText;
            }
            let r = calculation();
            if (showResult != 1) {
                if (isConstract === 0) {
                    saveNum.innerHTML += (" " + secondValue + " =");
                } else {
                    saveNum.innerHTML += (" (" + secondValue + ") =");
                }
                result.innerHTML = r;
            }
            showResult = 1;
            isOpPressed = 0;
        }
        animation();
    } else {
        shake_animation();
    }
}

function constract() {
    let num = -result.innerText;
    result.innerText = num;
}

function calculation() {
    firstValue = +firstValue;
    secondValue = +secondValue;
    if (secondValue < 0) {
        isConstract = 1;
    } else {
        isConstract = 0;
    }
    let r;
    switch (OPERATOR) {
        case '+':
            r = firstValue + secondValue;
            break;
        case '-':
            r = firstValue - secondValue;
            break;
        case 'x':
            r = firstValue * secondValue;
            break;
        case '/':
            if (secondValue != 0) {
                r = firstValue / secondValue;
            } else {
                isUndefined = 1;
                r = "undefined";
            }
            break;
        case '%':
            if (secondValue != 0) {
                r = firstValue % secondValue;
            } else {
                r = "undefined";
                isUndefined = 1;
            }
            break;
    }
    return r;
}


function animation() {
    document.getElementById("textNumber").classList.add("moveUp");
    document.getElementById("saveNumber").classList.add("smaller");
    if (document.getElementById("textNumber").classList.contains("moveUp")) {
        reset_animation();
    }
}

function reset_value() {
    document.getElementById("saveNumber").innerText = document.getElementById("textNumber").innerText;
    document.getElementById("textNumber").innerText = "0";
}

function handle2op(op) {
    let r = calculation();
    OPERATOR = op;
    result.innerText = (r + " " + op);
}

function shake_animation() {
    let contains = document.querySelector(".container");
    if (contains.classList.contains("shake")) {
        contains.style.animation = 'none';
        contains.offsetHeight;
        contains.style.animation = null;
    }
    contains.classList.add("shake");
    delayAC_animation();
}

function delayAC_animation() {
    if (Clear.classList.contains("delayAC")) {
        Clear.style.animation = 'none';
        Clear.offsetHeight;
        Clear.style.animation = null;
    }
    Clear.classList.add("delayAC");
}

function reset_animation() {
    var el = document.getElementById('textNumber');
    var e2 = document.getElementById('saveNumber');
    el.style.animation = 'none';
    el.offsetHeight; /* trigger reflow */
    el.style.animation = null;
    e2.style.animation = 'none';
    e2.offsetHeight;
    e2.style.animation = null;
}

// KEY BINDING
document.onkeydown = function(e) {
    let num = e.which - 48;
    let isShift = !!window.event.shiftKey;
    if (e.which === 189) {
        op("-");
    } else if (e.which === 191) {
        op("/");
    } else if (isShift) {
        if (e.which === 187) {
            op("+");
        } else if (e.which === 56) {
            op("x");
        } else if (e.which === 53) {
            op("%");
        }
    } else if (e.which === 13 || e.which === 187) {
        equal();
    } else if (e.which === 27) {
        clr();
    } else if (num >= 0 && num <= 9) {
        addToNumber(num);
    }

}

//MENU FUNCTIONALITY
//DEFAULT MODE: STANDARD
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
    Menubtns[0].classList.add("MenuListStayActive");
}