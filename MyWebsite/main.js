let Numa = "";
let Numb = "";
let result = "";


function addToResult() {
    let b;
    let number = 0;
    if ((result === "")) {
        console.log("hellos");
        document.getElementById("number").innerText = "";
    }
    console.log("Result is :" + result);
    for (let i = 0; i < 10; i++) {
        b = document.getElementById(`button${i}`);
        b.onclick = function () {
            number = i;
            document.getElementById("number").innerText += number;
        }
    }
}

function Add() {
    let num = document.getElementById("number").innerText;
    if (!(num === "")) {
        document.getElementById("saveNumber").innerText = num + " +";
        document.getElementById("number").innerText = "";
        Numa = num;
    }

}

function Sub() {
    let num = document.getElementById("number").innerText;
    if (!(num === "")) {
        document.getElementById("saveNumber").innerText = num + " -";
        document.getElementById("number").innerText = "";
        Numa = num;
    }
}

function Mul() {
    let num = document.getElementById("number").innerText;
    if (!(num === "")) {
        document.getElementById("saveNumber").innerText = num + " x";
        document.getElementById("number").innerText = "";
        Numa = num;
    }
}

function Div() {
    let num = document.getElementById("number").innerText;
    if (!(num === "")) {
        document.getElementById("saveNumber").innerText = num + " /";
        document.getElementById("number").innerText = "";
        Numa = num;
    }
}

function Equal() {
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
        }
    }
}

function clearAll() {
    document.getElementById("number").innerText = "";
    document.getElementById("saveNumber").innerText = "";
    Numa = "";
    Numb = "";
}