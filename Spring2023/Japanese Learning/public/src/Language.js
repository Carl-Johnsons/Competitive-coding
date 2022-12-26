 class Language {
     constructor(language, Vietnamese, Romanji) {
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
         this.RomanjiCharacter = ["a", "i", "u", "e", "o",
             "ka", "ki", "ku", "ke", "ko",
             "sa", "shi", "su", "se", "so",
             "ta", "chi", "tsu", "te", "to",
             "na", "ni", "nu", "ne", "no",
             "ha", "hi", "fu", "he", "ho",
             "ma", "mi", "mu", "me", "mo",
             "ya", "yu", "yo",
             "ra", "ri", "ru", "re", "ro",
             "wa", "o",
             "n"
         ];
         this.language = language;
         this.Vietnamese = Vietnamese;
         this.Romanji = Romanji;
         this.Hiragana = this.covertRoToHi(Romanji);

     }
     covertRoToHi(Romanji) {
         Romanji = Romanji.trim().toLowerCase();
         let translation = "",
             temp;
         let start_i = 0;
         let end_i = 1;
         for (let i = 0; i < Romanji.length; i++) {
             temp = Romanji.substring(start_i, end_i);
             temp = this.RomanjiCharacter.findIndex((e) => { return e === temp });
             if (temp === 45) {
                 // Handle "n" characters with na ni ne nu no
                 end_i++;
                 let temp_2 = Romanji.substring(start_i, end_i)
                 let r = this.RomanjiCharacter.findIndex((e) => { return e === temp_2 })
                 if (r === -1) {
                     end_i--;
                 } else {
                     start_i = end_i;
                     translation += this.HiraganaCharacter[r];
                 }
             } else if (temp !== -1) {
                 start_i = end_i;
                 translation += this.HiraganaCharacter[temp];
             }
             end_i++;
         };

         return translation;
     }

     covertHiToRo(Hiragana) {

     }
 }
 module.exports = Language;