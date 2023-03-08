 class Language {
     constructor(language, Vietnamese, Romaji) {
         //Declare Character
         const [Hi, Ro] = this.getFullHiraganaAndFullRomaji();
         this.FullHiragana = Hi;
         this.FullRomaji = Ro;
         this.FullAlphabet = this.getFullAlphabeticalCharacter();
         this.CommonSpecialCharacter = this.getCommonSpecialCharacter();

         this.language = language;
         if (this.language === "tool") {

         } else {
             this.Vietnamese = Vietnamese;
             this.Romaji = Romaji;
             this.Hiragana = this.covertRoToHi(Romaji);
         }

     }
     covertRoToHi(Romaji) {
         if (Romaji) {
             let translation = "",
                 temp, index;
             let start_i = 0;
             for (let end_i = 1; end_i <= Romaji.length; end_i++) {
                 //Brute Force translation
                 temp = Romaji.substring(start_i, end_i);
                 index = this.IsCommonSpecialCharacter(temp);
                 if (index !== -1) {
                     translation += temp;
                     start_i = end_i;
                 } else {
                     index = this.IsRomaji(temp);
                     console.log({ index });
                     if (temp === "n" || temp === "ん") {
                         // Handle "n" characters with na ni ne nu no
                         let temp_2 = "n" + Romaji.substring(start_i + 1, end_i + 1);
                         let index_2 = this.IsRomaji(temp_2);
                         if (index_2 === -1) {
                             //If can't find na ni ne nu no => += "n"
                             translation += "ん";
                         } else {
                             translation += this.FullHiragana[index_2];
                             end_i++;
                         }
                         start_i = end_i;
                     } else if (index !== -1) {
                         start_i = end_i;
                         translation += this.FullHiragana[index];
                     } else {
                         //Handle Characters that not in the Romaji
                         if (temp.length === 3) {
                             translation += temp[0];
                             end_i -= 2;
                             start_i = end_i;
                         } else if (end_i === Romaji.length) {
                             translation += temp;
                         }
                     }
                 }
             };
             return translation;
         }
         return;
     }
     covertHiToRo(Hiragana) {

     }
     IsRomaji(Romaji) {
         let index = this.FullRomaji.findIndex(e => { return Romaji.trim().toLowerCase() === e.trim().toLowerCase() });
         return index;
     }
     IsHiragana(Hiragana) {
         let index = this.FullHiragana.findIndex(e => { return Hiragana === e });
         return index;

     }
     IsCommonSpecialCharacter(SpecialCharacter) {
         let index = this.CommonSpecialCharacter.findIndex(e => { return SpecialCharacter === e });
         return index;
     }

     //Get Character Source
     getFullHiraganaAndFullRomaji() {
         let HiraganaCharacter, RomajiCharacter,
             dakutenCharacter, dakutenRomajiCharacter,
             yoonCharacter, yoonRomajiCharacter,
             yoonDakutenCharacter, yoonDakutenRomajiCharacter;
         HiraganaCharacter = ["あ", "い", "う", "え", "お",
             "か", "き", "く", "け", "こ",
             "さ", "し", "す", "せ", "そ",
             "た", "ち", "つ", "て", "と",
             "な", "に", "ぬ", "ね", "の",
             "は", "ひ", "ふ", "へ", "ほ",
             "ま", "み", "む", "め", "も",
             "や", "ゆ", "よ",
             "ら", "り", "る", "れ", "ろ",
             "わ", "を",
             "ん"
         ];
         RomajiCharacter = ["a", "i", "u", "e", "o",
             "ka", "ki", "ku", "ke", "ko",
             "sa", "shi", "su", "se", "so",
             "ta", "chi", "tsu", "te", "to",
             "na", "ni", "nu", "ne", "no",
             "ha", "hi", "fu", "he", "ho",
             "ma", "mi", "mu", "me", "mo",
             "ya", "yu", "yo",
             "ra", "ri", "ru", "re", "ro",
             "wa", "wo",
             "n"
         ];
         dakutenCharacter = ["が", "ぎ", "ぐ", "げ", "ご",
             "ざ", "じ", "ず", "ぜ", "ぞ",
             "だ", "ぢ", "づ", "で", "ど",
             "ば", "び", "ぶ", "べ", "ぼ",
             "ぱ", "ぴ", "ぷ", "ぺ", "ぽ"
         ];
         dakutenRomajiCharacter = ["ga", "gi", "gu", "ge", "go",
             "za", "ji", "zu", "ze", "zo",
             "da", "dji", "dzu", "de", "do",
             "ba", "bi", "bu", "be", "bo",
             "pa", "pi", "pu", "pe", "po",
         ];
         // Combination of hiragana and gojuon with ya ye yo
         yoonCharacter = ["きゃ", "きゅ", "きょ",
             "ぎゃ", "ぎゅ", "ぎょ",
             "にゃ", "にゅ", "にょ",
             "ひゃ", "ひゅ", "ひょ",
             "びゃ", "びゅ", "びょ",
             "ぴゃ", "ぴゅ", "ぴょ",
             "みゃ", "みゅ", "みょ",
             "りゃ", "りゅ", "りょ",
             "しゃ", "しゅ", "しょ",
             "じゃ", "じゅ", "じょ",
             "ちゃ", "ちゅ", "ちょ",
         ]
         yoonRomajiCharacter = ["kya", "kyu", "kyo",
             "gya", "gyu", "gyo",
             "nya", "nyu", "nyo",
             "hya", "hyu", "hyo",
             "bya", "byu", "byo",
             "pya", "pyu", "pyo",
             "mya", "myu", "myo",
             "rya", "ryu", "ryo",
             "sha", "shu", "sho",
             "ja", "ju", "jo",
             "cha", "chu", "cho",
         ]
         yoonDakutenCharacter = ["ぎゃ", "ぎゅ", "ぎぇ", "ぎょ",
             "じゃ", "じゅ", "じぇ", "じょ",
             "ぢゃ", "ぢゅ", "ぢぇ", "ぢょ",
             "びゃ", "びゅ", "びぇ", "びょ",
             "ぴゃ", "ぴゅ", "ぴょ", "ぴぇ",
         ];
         yoonDakutenRomajiCharacter = ["gya", "gyu", "gye", "gyo",
             "ja", "ju", "je", "jo",
             "dja", "dju", "dje", "djo",
             "bya", "byu", "bye", "byo",
             "pya", "pyu", "pye", "pyo",
         ];
         let Hiragana = HiraganaCharacter.concat(dakutenCharacter, yoonCharacter, yoonDakutenCharacter);
         let Romaji = RomajiCharacter.concat(dakutenRomajiCharacter, yoonRomajiCharacter, yoonDakutenRomajiCharacter);
         return [Hiragana, Romaji];
     }
     getCommonSpecialCharacter() {
         let commonSpecialCharacter = [],
             comparisonCharacter = [],
             MathematicalCharacter = [],
             leastCommonCharacter = [123, 125, 126];
         for (let i = 32; i <= 47; i++) {
             commonSpecialCharacter[i - 32] = String.fromCharCode(i);
         }
         for (let i = 58; i <= 64; i++) {
             comparisonCharacter[i - 58] = String.fromCharCode(i);
         }
         for (let i = 91; i <= 96; i++) {
             MathematicalCharacter[i - 91] = String.fromCharCode(i);
         }
         for (let i = 0; i < leastCommonCharacter.length; i++) {
             leastCommonCharacter[i] = String.fromCharCode(leastCommonCharacter[i]);
         }
         let AllSpecial = commonSpecialCharacter.concat(comparisonCharacter, MathematicalCharacter, leastCommonCharacter);
         return AllSpecial;
     }
     getFullAlphabeticalCharacter() {
         let lowercase = [],
             uppercase = [];
         for (let i = 97; i <= 122; i++) {
             lowercase[i - 97] = String.fromCharCode(i);
         }
         for (let i = 65; i <= 90; i++) {
             uppercase[i - 65] = String.fromCharCode(i);

         }
         return lowercase.concat(uppercase);
     }
 }

 module.exports = Language;