const express = require('express');
const fs = require("fs");
const Language = require('./public/src/Language');

const app = express();
const port = 3000;
// Get src file
const LanguageSrc = fs.readFileSync("src.txt").toString().split("\r\n");

const VietnameseSrc = LanguageSrc.filter((value, index) => index % 2 == 0);
const JapaneseSrc = LanguageSrc.filter((value, index) => index % 2 == 1);
let modeTranslate = "JAP";
const coverter = [];
let result = "";
let translation = "";
let tool = new Language("tool");
for (let i = 0; i < VietnameseSrc.length; i++) {
    coverter[i] = new Language("Viet-Jap", VietnameseSrc[i], JapaneseSrc[i]);
}
//Get all file to code in public folder
app.use(express.static('public'));
app.use(express.json())

app.get('/result', (req, res) => {
    res.status(200).json({
        result: translation,
        VieSrc: VietnameseSrc,
        JapSrc: JapaneseSrc,
    });
});

// Handle post and get request
app.post('/', (req, res) => {
    const body = req.body
    if (!body) {
        return res.status(400).send({ status: "failed" })
    } else {
        if (modeTranslate === "JAP") {
            translation = handleSearchJap(body.search);
        } else if (modeTranslate === "VIE") {
            //DO something here
        }
        return res.status(200).send({ status: "ok" })
    }
})
app.get('/', (req, res) => {});
app.post('/changeMode', (req, res) => {
    const body = req.body
    if (!body) {
        return res.status(400).send({ status: "failed" })
    } else {
        modeTranslate = body.mode;
        return res.status(200).send({ status: "ok" })
    }

})
app.get('/changeMode', (req, res) => {
    // res.status(200).json({
    //     mode: mode,
    // });
});
app.get("/mode/TestSkill/src", (req, res) => {
    res.status(200).json({
        Question: VietnameseSrc,
        Answer: JapaneseSrc
    });
})


app.listen(port, () => {
    console.log(`Server listening on ${port}`);
});

function handleSearchJap(value) {
    if (value) {
        result = coverter.findIndex((l) => l.Romaji.toLowerCase() === value.trim().toLowerCase())
        if (result === -1) {
            translation = tool.covertRoToHi(value); // Fix something here
        } else {
            translation = coverter[result].Vietnamese + "\n" + coverter[result].Hiragana;
        }
        return translation;
    }
    return "";
}