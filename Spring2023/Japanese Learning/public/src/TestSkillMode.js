const startPanel = document.querySelector(".start-panel");
const ResultTable = document.querySelector(".result-table");
const TableBody = document.querySelector(".result-table > tbody");
const TableHeader = document.querySelectorAll(".result-table > thead");
const startBtn = startPanel.querySelector(".start-btn");
const container = document.querySelector(".container");
const resultContainer = document.querySelector(".result-container");
const retryBtn = document.querySelector(".retry-btn");

const tdata = [],
    trow = [];
const QuestionBtn = [];
const Question = [];
const Answer = [];
const input = [];
const AnswerHiragana = [];
const MAX_QUESTION = 10;
let isAnimating = false;
let submit;
let QuestionBank;
let AnswerBank;

createUI();

startBtn.addEventListener("click", () => {
    handleStartBtnEvent();
})
retryBtn.addEventListener("click", () => {
    handleRetryBtnEvent();
});


function createUI() {
    for (let i = 0; i < MAX_QUESTION; i++) {
        createQuestionLabel(i);
        createQuestionButton(i, i + 1);
        createInput(i);
    }
    createSubmitButton();
}
async function handleData() {
    await getQuestionBank();
    let RandomQ = generateQuestion();
    setQuestionLabel(RandomQ);
}

function createQuestionLabel(index) {
    Question[index] = document.createElement("div");
    Question[index].setAttribute("class", "question hidden");

    if (index === 0) {
        Question[index].classList.remove("hidden");
    }

    container.appendChild(Question[index]);
}

async function setQuestionLabel(Random) {
    for (let i = 0; i < Question.length; i++) {
        Question[i].innerText = QuestionBank[Random[i]];
        Answer[i] = AnswerBank[Random[i]];
    }
}

function createInput(index) {
    input[index] = document.createElement("input");
    input[index].classList.add("hidden");
    input[index].setAttribute("type", "text");
    input[index].setAttribute("placeholder", "               Input Answer here");
    input[index].setAttribute("tabindex", "0");

    if (index === 0) {
        input[0].classList.remove("hidden");
    }

    container.appendChild(input[index]);
}

function createQuestionButton(index, text) {
    QuestionBtn[index] = document.createElement("button");
    QuestionBtn[index].setAttribute("class", "question-btn");
    QuestionBtn[index].innerText = text;
    // QuestionBtn[index].setAttribute("tabindex", "0");

    QuestionBtn[index].addEventListener("click", e => {
        let btn = e.target;
        handleQuestionBtnEvent(btn);
    });

    if (index === 0) {
        QuestionBtn[index].classList.add("question-btn-active");
    }

    container.appendChild(QuestionBtn[index]);
}

function handleQuestionBtnEvent(btn) {
    QuestionBtn.forEach((Qbtn) => {
        Qbtn.classList.remove("question-btn-active");
    });
    for (let i = 0; i < QuestionBtn.length; i++) {
        if (input[i].value !== "") {
            QuestionBtn[i].classList.add("input-occupied");
        } else {
            QuestionBtn[i].classList.remove("input-occupied");
        }
    }
    let questionIndex = QuestionBtn.indexOf(btn);
    UpdateQuestion(questionIndex);
    btn.classList.add("question-btn-active");
}

function createSubmitButton() {
    submit = document.createElement("button");
    submit.setAttribute("class", "submit-btn");
    submit.innerText = "Submit";
    submit.addEventListener("click", e => {
        handleSubmitBtnEvent();

    });

    document.body.appendChild(submit);

}

function UpdateQuestion(index) {
    Question.forEach(i => {
        i.classList.add("hidden");
    })
    input.forEach(i => {
        i.classList.add("hidden");
    })
    Question[index].classList.remove("hidden");
    input[index].classList.remove("hidden");
    input[index].focus();
}

function generateQuestion() {
    let temp, next = 0,
        Random = [];
    while (true) {
        if (next === 10) {
            break;
        }
        temp = Math.floor(Math.random() * QuestionBank.length);
        if (!Random.includes(temp)) {
            Random[next] = temp;
            next++;
        }
    }
    return Random;
}

async function getQuestionBank() {
    const res = await fetch('/mode/TestSkill/src', {
        method: 'GET',
    })
    const data = await res.json();
    QuestionBank = data.Question;
    AnswerBank = data.Answer;
}

function handleStartBtnEvent() {
    if (!isAnimating) {
        isAnimating = true;
        startPanel.classList.add("move-out");
        handleData();
        input[0].focus();
        setTimeout(() => {
            isAnimating = false;
        }, 1000);
    }
}

async function handleSubmitBtnEvent() {
    if (!isAnimating) {
        isAnimating = true;
        resultContainer.classList.add("move-in");
        resultContainer.classList.remove("move-out");
        for (let i = 0; i < QuestionBtn.length; i++) {
            trow[i] = document.createElement("tr");
            for (let j = 0; j < 4; j++) {
                tdata[j] = document.createElement("td");
                trow[i].appendChild(tdata[j]);
            }
            tdata[0].innerText = Question[i].innerText;
            tdata[1].innerText = input[i].value;
            tdata[2].innerText = Answer[i];
            await postAnswer(Answer[i])
            await getAnswerTranslations()
                .then((data) => {
                    data = data.split('\n');
                    tdata[3].innerText = data[data.length - 1];
                })
        }

        for (let i = 0; i < QuestionBtn.length; i++) {
            setTimeout(() => {
                TableBody.appendChild(trow[i]);
            }, 300 + (i % QuestionBtn.length) * 50);
        }
        let score = 0;
        for (let i = 0; i < Question.length; i++) {
            if (Answer[i] === input[i].value) {
                score++;
                trow[i].classList.add("right-ans");
            } else {
                trow[i].classList.add("wrong-ans");
            }
        }
        console.log(score);
        setTimeout(() => {
            isAnimating = false;
        }, 1000);
    }
}
async function postAnswer(ans) {
    const res = await fetch('/', {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            search: ans,
        })
    });
}
async function getAnswerTranslations() {
    return await fetch("/result", {
            method: "GET",
        }).then(res => res.json())
        .then((data) => {
            return data.result;
        });
}

function handleRetryBtnEvent() {
    if (!isAnimating) {
        isAnimating = true;
        startPanel.classList.add("move-in");
        startPanel.classList.remove("move-out");
        setTimeout(() => {
            resultContainer.classList.remove("move-in");
            resultContainer.classList.add("move-out");

            //Reset table data
            while (TableBody.firstChild) {
                TableBody.removeChild(TableBody.firstChild);
            }
            TableBody.innerHTML = `                
        <tr>
            <th>Question</th>
            <th>Your Answer</th>
            <th>The Answer</th>
            <th>Hiragana</th>
        </tr>`;
        }, 300);
        input.forEach(i => {
            i.value = "";
        })
        QuestionBtn.forEach(Qbtn => {
            Qbtn.classList.remove("input-occupied");
        })
        setTimeout(() => {
            isAnimating = false;
        }, 1000);
    }
}

document.onkeydown = (e) => {
    if (e.which === 9) { //TAB key
        if (startPanel.classList.contains("move-out") && resultContainer.classList.contains("move-out")) {
            let cur_index = 0;
            for (let i = 0; i < QuestionBtn.length; i++) {
                if (QuestionBtn[i].classList.contains("question-btn-active")) {
                    cur_index = i;
                }
            }
            let next_index = (cur_index + 1) % QuestionBtn.length;
            handleQuestionBtnEvent(QuestionBtn[next_index]);
            QuestionBtn[next_index].focus();
        }
    } else if (e.which === 13) { // ENTER key
        if (startPanel.classList.contains("move-out") && resultContainer.classList.contains("move-out")) {
            handleSubmitBtnEvent();
        } else if (startPanel.classList.contains("move-out") && resultContainer.classList.contains("move-in")) {
            handleRetryBtnEvent();
        } else {
            handleStartBtnEvent();
        }
    }
}