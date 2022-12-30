 class Language {
     constructor(language, Vietnamese, Romaji) {
         this.HiraganaCharacter = ["あ", "い", "う", "え", "お",
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

         this.RomajiCharacter = ["a", "i", "u", "e", "o",
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
         this.dakutenCharacter = ["が", "ぎ", "ぐ", "げ", "ご",
             "ざ", "じ", "ず", "ぜ", "ぞ",
             "だ", "ぢ", "づ", "で", "ど",
             "ば", "び", "ぶ", "べ", "ぼ",
             "ぱ", "ぴ", "ぷ", "ぺ", "ぽ"
         ];
         this.dakutenRomajiCharacter = ["ga", "gi", "gu", "ge", "go",
             "za", "ji", "zu", "ze", "zo",
             "da", "dji", "dzu", "de", "do",
             "ba", "bi", "bu", "be", "bo",
             "pa", "pi", "pu", "pe", "po",
         ];
         // Combination of hiragana and gojuon with ya ye yo
         this.yoonCharacter = ["きゃ", "きゅ", "きょ",
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

         this.yoonRomajiCharacter = ["kya", "kyu", "kyo",
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
         this.yoonDakutenCharacter = ["ぎゃ", "ぎゅ", "ぎぇ", "ぎょ",
             "じゃ", "じゅ", "じぇ", "じょ",
             "ぢゃ", "ぢゅ", "ぢぇ", "ぢょ",
             "びゃ", "びゅ", "びぇ", "びょ",
             "ぴゃ", "ぴゅ", "ぴょ", "ぴぇ",
         ];
         this.yoonDakutenRomajiCharacter = ["gya", "gyu", "gye", "gyo",
             "ja", "ju", "je", "jo",
             "dja", "dju", "dje", "djo",
             "bya", "byu", "bye", "byo",
             "pya", "pyu", "pye", "pyo",
         ];
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
             Romaji = Romaji.trim().toLowerCase();
             let translation = "",
                 temp, index;
             let start_i = 0;
             for (let end_i = 1; end_i <= Romaji.length; end_i++) {
                 let isYoon = false;
                 let isYoonDakuten = false;
                 let isBasic = false;
                 let isdakuten = false;
                 temp = Romaji.substring(start_i, end_i);
                 index = this.yoonRomajiCharacter.findIndex(e => { return e === temp });
                 isYoon = true;
                 if (index === -1) {
                     index = this.yoonDakutenRomajiCharacter.findIndex((e) => { return e === temp });
                     isYoonDakuten = true;
                     isYoon = false;
                     isBasic = false;
                     isdakuten = false;
                 }
                 if (index === -1) {
                     index = this.RomajiCharacter.findIndex((e) => { return e === temp });
                     isYoonDakuten = true;
                     isYoon = false;
                     isBasic = true;
                     isdakuten = false;
                 }
                 if (index === -1) {
                     index = this.dakutenRomajiCharacter.findIndex((e) => { return e === temp });
                     isYoonDakuten = true;
                     isYoon = false;
                     isBasic = false;
                     isdakuten = true;
                 }
                 if (temp === "n") {
                     // Handle "n" characters with na ni ne nu no
                     end_i++;
                     let temp_2 = Romaji.substring(start_i, end_i)
                     let r = this.RomajiCharacter.findIndex((e) => { return e === temp_2 })
                     if (r === -1) {
                         end_i--;
                         start_i = end_i;
                         //If can't find na ni ne nu no => += "n"
                         translation += this.HiraganaCharacter[45];
                     } else {
                         start_i = end_i;
                         translation += this.HiraganaCharacter[r];
                     }
                 } else if (index !== -1) {
                     start_i = end_i;
                     if (isBasic) {
                         translation += this.HiraganaCharacter[index];
                     } else if (isdakuten) {
                         translation += this.dakutenCharacter[index];
                     } else if (isYoon) {
                         translation += this.yoonCharacter[index];
                     } else if (isYoonDakuten) {
                         translation += this.yoonDakutenCharacter[index];
                     }
                 }
             };

             return translation;
         }
         return;
     }

     covertHiToRo(Hiragana) {

     }
 }
 module.exports = Language;