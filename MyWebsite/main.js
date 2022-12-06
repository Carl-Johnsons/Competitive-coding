let Numa = "";
let Numb = "";
let Ans = "";
let OPERATOR;
let result;


function addToResult() {
    let b;
    let number = 0;

    console.log("Result is :" + result);
    for (let i = 0; i < 10; i++) {
        b = document.getElementById(`button${i}`);
        b.onclick = function () {
            number = i;
            let str = document.getElementById("number").innerText;
            if (str.length < 30) {
                document.getElementById("number").innerText += number;
            }
        }
    }
}

function Add() {
    let num = document.getElementById("number").innerText;
    let saveNumber = document.getElementById("saveNumber").innerText;
    if (!(saveNumber === "") && !(num === "")) {
        let op = saveNumber.charAt(saveNumber.length - 1);
        OPERATOR = '+';
        Numa = saveNumber;
        Numb = num;
        handle2op(op);
    } else if (!(num === "")) {
        document.getElementById("saveNumber").innerText = num + " +";
        document.getElementById("number").innerText = "";
        Numa = num;
    }

}

function Sub() {
    let num = document.getElementById("number").innerText;
    let saveNumber = document.getElementById("saveNumber").innerText;

    if (!(saveNumber === "") && !(num === "")) {
        let op = saveNumber.charAt(saveNumber.length - 1);
        OPERATOR = '-';
        Numa = saveNumber;
        Numb = num;
        handle2op(op);
    } else if (!(num === "")) {
        document.getElementById("saveNumber").innerText = num + " -";
        document.getElementById("number").innerText = "";
        Numa = num;
    }
}

function Mul() {
    let num = document.getElementById("number").innerText;
    let saveNumber = document.getElementById("saveNumber").innerText;

    if (!(saveNumber === "") && !(num === "")) {
        let op = saveNumber.charAt(saveNumber.length - 1);
        OPERATOR = 'x';
        Numa = saveNumber;
        Numb = num;
        handle2op(op);
    } else if (!(num === "")) {
        document.getElementById("saveNumber").innerText = num + " x";
        document.getElementById("number").innerText = "";
        Numa = num;
    }
}

function Div() {
    let num = document.getElementById("number").innerText;
    let saveNumber = document.getElementById("saveNumber").innerText;

    if (!(saveNumber === "") && !(num === "")) {
        let op = saveNumber.charAt(saveNumber.length - 1);
        OPERATOR = '/';
        Numa = saveNumber;
        Numb = num;
        handle2op(op);
    } else if (!(num === "")) {
        document.getElementById("saveNumber").innerText = num + " /";
        document.getElementById("number").innerText = "";
        Numa = num;
    }
}

function Equal() {
    console.log(Numa + " " + Numb + " = " + result);
    if (!(Numa === "")) {
        Numb = document.getElementById("number").innerText;
        if (!(Numb === "")) {
            let str = document.getElementById("saveNumber").innerText;
            let operator = str.charAt(str.length - 1);
            switch (operator) {
                case '+':
                    result = parseInt(Numa) + parseInt(Numb);
                    break;
                case '-':
                    result = parseInt(Numa) - parseInt(Numb);
                    break;
                case 'x':
                    result = parseInt(Numa) * parseInt(Numb);
                    break;
                case '/':
                    if (parseInt(Numb) != 0) {
                        result = parseInt(Numa) / parseInt(Numb);
                    } else {
                        result = "undefined";
                    }
                    break;
            }
            document.getElementById("saveNumber").innerText = "";
            document.getElementById("number").innerText = result;
        } else {
            result = parseInt(Numa);
            document.getElementById("number").innerText = result;
        }
    }
}

function clearAll() {
    document.getElementById("number").innerText = "";
    document.getElementById("saveNumber").innerText = "";
    Numa = "";
    Numb = "";
}

function Delete() {
    let str = document.getElementById("number").innerText;
    if (str.length > 0) {
        document.getElementById("number").innerText = str.substring(0, str.length - 1);
    }
}

function handle2op(op) {
    switch (op) {
        case '+':
            result = parseInt(Numa) + parseInt(Numb);
            break;
        case '-':
            result = parseInt(Numa) - parseInt(Numb);
            break;
        case 'x':
            result = parseInt(Numa) * parseInt(Numb);
            break;
        case '/':
            if (parseInt(Numb) != 0) {
                result = parseInt(Numa) / parseInt(Numb);
            } else {
                result = "undefined";
            }
            break;
    }
    document.getElementById("saveNumber").innerText = result + " " + OPERATOR;
    document.getElementById("number").innerText = "";
    Numa = result;
    Numb = "";
}

// KEY BINDING
document.onkeydown = function (e) {
    let num = e.which - 48;
    let isShift = !!window.event.shiftKey;
    console.log(e.which);
    if (e.which === 8) {
        Delete();
    } else if (e.which === 189) {
        Sub();
    } else if (e.which === 191) {
        Div();
    } else if (isShift) {
        if (e.which === 187) {
            Add();
        } else if (e.which === 56) {
            Mul();
        }
    } else if (e.which === 13 || e.which === 187) {
        Equal();
    } else if (e.which === 27) {
        clearAll();
    } else if (num >= 0 && num <= 9) {
        let str = document.getElementById("number").innerText;
        if (str.length < 30) {
            document.getElementById("number").innerText += num;
        }
    }

}