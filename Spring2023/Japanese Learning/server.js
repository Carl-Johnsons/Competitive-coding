const express = require('express');
const fs = require("fs");
const Language = require('./public/src/Language');

const app = express();
const port = 3000;
// Get src file
const LanguageSrc = fs.readFileSync("src.txt").toString().split("\r\n");
const VietnameseSrc = LanguageSrc.filter((value, index) => index % 2 == 0);
const JapaneseSrc = LanguageSrc.filter((value, index) => index % 2 == 1);
const coverter = [];
let result = "";
let translation = "";
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
// Handle post request
app.post('/', (req, res) => {
    const search = req.body
    if (!search) {
        return res.status(400).send({ status: "failed" })
    } else {
        translation = handleSearch(search.search);

        return res.status(200).send({ status: "ok" })
    }
})
app.get('/', (req, res) => {
    console.log("im in");
});
app.listen(port, () => {
    console.log(`Server listening on ${port}`);
});


function handleSearch(value) {
    result = coverter.findIndex((l) => l.Romanji.toLowerCase() === (value.trim().toLowerCase()))
    if (result === -1) {
        translation = value
    } else {
        translation = coverter[result].Vietnamese + "\n" + coverter[result].Hiragana;
    }
    return translation;
}