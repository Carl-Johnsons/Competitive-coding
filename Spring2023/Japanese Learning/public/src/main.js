const Container_1 = document.querySelector(".container#_1");
const ModeContainer = document.querySelector(".Mode");
const ModeBtns = document.querySelectorAll(".Modebtn");
const lineAnim = createLineAnim("line1");
const lineAnim2 = createLineAnim("line2");
lineAnim.classList.add("changeBack_1");
lineAnim2.classList.add("changeBack_2");
const ModeSelected = [true, false, false, true];
let currentMode = "JAP";
let VietnameseSrc = [];
let JapaneseSrc = [];
let hint = [];

//Detect p tag changes
const target = document.querySelector("#_1 > p");
const result = document.querySelector("#_2 > p");
const observer = new MutationObserver(mutation => {
    mutation.forEach((e) => {
        if (target.innerText !== "") {
            createHint(target.innerText);
        }
        postSearch();
        getSearchResult();
    });
});
const observerConfig = {
    attributes: true,
    characterData: true,
    childList: true,
    subtree: true
}
observer.observe(target, observerConfig);

// Interact with back-end
const baseURL = "http://localhost:3000/";

// This make VietnameseSrc and JapaneseSrc become available
getSearchResult();

async function postSearch() {
    const res = await fetch(baseURL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            search: target.innerText
        })
    })
}
async function getSearchResult() {
    const res = await fetch(baseURL + "result", {
        method: "GET"
    })
    const data = await res.json();
    result.innerText = data.result;
    VietnameseSrc = data.VieSrc;
    JapaneseSrc = data.JapSrc;
}
async function postMode() {
    const res = await fetch(baseURL + "changeMode", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            mode: currentMode
        })
    })
}
//Create hint text
function createHint(text) {
    text = text.trim().toLowerCase();
    let nearly_match = (currentMode === "JAP" ? JapaneseSrc.filter(t => t.includes(text)) : -1);
    for (let i = 0; i < 3; i++) {
        hint[i].innerText = nearly_match[i];
        if (nearly_match[i]) {
            hint[i].classList.remove("hidden");
        } else {
            hint[i].classList.add("hidden");
        }
    }
}
for (let i = 0; i < 3; i++) {
    hint[i] = document.createElement('div');
    hint[i].setAttribute('class', 'hint hidden');
    hint[i].innerText = "";
    hint[i].addEventListener("click", (e) => {
        let value = e.target;
        target.innerText = value.innerText;
        for (let i = 0; i < 3; i++) {
            hint[i].innerText = undefined;
        }
    })
    Container_1.append(hint[i]);
}
//Animation
for (let i = 0; i < ModeBtns.length; i++) {
    ModeBtns[i].addEventListener("click", (e) => {
        let target = e.target;
        let valueID = e.target.id;
        if ((valueID === '__1' || valueID === "__4") && ModeSelected[1]) {
            lineAnim.classList.toggle("changeBack_1");
            lineAnim2.classList.toggle("changeBack_2");
            lineAnim.classList.toggle("changeMode_1");
            lineAnim2.classList.toggle("changeMode_2");
            for (let j = 0; j < ModeSelected.length; j++) {
                ModeSelected[j] = !ModeSelected[j];
            }
            currentMode = "JAP";
            postMode();
        } else if ((valueID === '__2' || valueID === "__3") && ModeSelected[0]) {
            lineAnim.classList.toggle("changeMode_1");
            lineAnim2.classList.toggle("changeMode_2");
            lineAnim.classList.toggle("changeBack_1");
            lineAnim2.classList.toggle("changeBack_2");
            for (let j = 0; j < ModeSelected.length; j++) {
                ModeSelected[j] = !ModeSelected[j];
            }
            currentMode = "VIE";
            postMode();
        }
    });
}


// MODE CONTAINER ADD ELEMENT
ModeContainer.appendChild(lineAnim);
ModeContainer.appendChild(lineAnim2);


function createLineAnim(id) {
    if (id !== undefined) {
        let lineAnim = document.createElement("div");
        lineAnim.classList.add("LineAnim");
        lineAnim.id = id;
        return lineAnim;
    }
    return;
}