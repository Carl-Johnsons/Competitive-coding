// Animation when choosing between modes
const ModeContainer = document.querySelector(".Mode");
const ModeBtns = document.querySelectorAll(".Modebtn");
const lineAnim = createLineAnim("line1");
const lineAnim2 = createLineAnim("line2");
lineAnim.classList.add("changeBack_1");
lineAnim2.classList.add("changeBack_2");
const ModeSelected = [true, false, false, true];

//Detect p tag changes
const target = document.querySelector("#_1 > p");
const result = document.querySelector("#_2 > p");
const observer = new MutationObserver(mutation => {
    mutation.forEach((e) => {
        postSearch();
        getSearchResult();
    });
});
console.log(target.innerText);
const observerConfig = {
    attributes: true,
    characterData: true,
    childList: true,
    subtree: true
}
observer.observe(target, observerConfig);

// Interact with back-end
const baseURL = "http://localhost:3000/";
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

    // console.log(res);
    const data = await res.json();
    console.log(data);
    result.innerText = data.result;
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
        } else if ((valueID === '__2' || valueID === "__3") && ModeSelected[0]) {
            lineAnim.classList.toggle("changeMode_1");
            lineAnim2.classList.toggle("changeMode_2");
            lineAnim.classList.toggle("changeBack_1");
            lineAnim2.classList.toggle("changeBack_2");
            for (let j = 0; j < ModeSelected.length; j++) {
                ModeSelected[j] = !ModeSelected[j];
            }
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