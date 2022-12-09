// MENU FUNCTIONALITY
let MenuList = document.querySelector(".MenuList");
let MenuIcon = document.querySelector(".MenuIcon");
let Menubtns = document.querySelectorAll(".Menubtn");
// DATE FUNCTIONALITY






//MENU FUNCTIONALITY
//DEFAULT MODE: Date
setDefaultMode();

MenuIcon.addEventListener("mouseenter", () => {
    MenuList.classList.remove("MenuListMoveOut");
    if (MenuList.classList.contains("MenuListMoveIn")) {
        MenuList.style.animation = 'none';
        MenuList.offsetHeight;
        MenuList.style.animation = null;
    }
    MenuList.classList.add("MenuListMoveIn");
});
MenuList.addEventListener("mouseleave", () => {
    MenuList.classList.remove("MenuListMoveIn");
    MenuList.classList.add("MenuListMoveOut");
});

for (let i = 0; i < Menubtns.length; i++) {
    Menubtns[i].addEventListener('click', () => {
        //Reset active mode
        for (let j = 0; j < Menubtns.length; j++) {
            Menubtns[j].classList.remove("MenuListStayActive");
        }
        if (i === 1) {
            alert("Unsupported feature! Please stay tune!");
            setDefaultMode();
        } else {
            Menubtns[i].classList.add("MenuListStayActive");
        }
    });
}

function setDefaultMode() {
    Menubtns[3].classList.add("MenuListStayActive");
}