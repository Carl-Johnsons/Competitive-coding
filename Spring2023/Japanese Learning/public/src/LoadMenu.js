import Menu from "/src/Menu.js"

const Menu_ = new Menu();
const URL = document.URL.toString().split("/");
Menu_.addItem("Translator", "/");
Menu_.addItem("Test Skill", "/mode/TestSkill.html");
Menu_.addItem("Translator", "/");

let currentMode = URL[URL.length - 1];
switch (currentMode) {
    case "TestSkill.html":
        Menu_.setItemActive(1, true);
        break;
    default:
        Menu_.setItemActive(0, true);
        break;
}