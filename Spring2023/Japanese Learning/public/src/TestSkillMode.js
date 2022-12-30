const container = document.querySelector(".container");
const QuestionBtn = [];
const Question = [];
const Answer = [];
const input = [];
const MAX_QUESTION = 10
let submit;
let QuestionBank;
let AnswerBank;

createUI();
handleData();

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
    input[index].setAttribute("placehold", "               Input Answer here");

    if (index === 0) {
        input[0].classList.remove("hidden");
    }

    container.appendChild(input[index]);
}

function createQuestionButton(index, text) {
    QuestionBtn[index] = document.createElement("button");
    QuestionBtn[index].setAttribute("class", "question-btn");
    QuestionBtn[index].innerText = text;

    QuestionBtn[index].addEventListener("click", e => {
        let btn = e.target;
        QuestionBtn.forEach((Qbtn) => {
            Qbtn.classList.remove("question-btn-active");
        })
        let questionIndex = QuestionBtn.indexOf(e.target);
        UpdateQuestion(questionIndex);
        btn.classList.add("question-btn-active");
    });

    if (index === 0) {
        QuestionBtn[index].classList.add("question-btn-active");
    }

    container.appendChild(QuestionBtn[index]);
}

function createSubmitButton() {
    let score = 0;
    submit = document.createElement("button");
    submit.setAttribute("class", "submit-btn");
    submit.innerText = "Submit";
    submit.addEventListener("click", e => {
        for (let i = 0; i < Question.length; i++) {
            if (Answer[i] === input[i].innerText) {
                score++;
            }
        }
        console.log(score);
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