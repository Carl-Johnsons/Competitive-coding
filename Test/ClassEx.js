export default class ClassEx {
    constructor() {
        this.name = "Jeff";
        this.loc = "Im a global variable";
        this.inititate();
        console.log("I make it through constructor");
        console.log("-----------------------------------");
    }
    inititate() {
        this.btn = document.querySelectorAll("button");
        this.context = document.querySelector(".container");
        this.btn[0].addEventListener("click", this.eventclicked);
        console.log("I make it through inititate state");
        console.log("this.context = " + this.context);
        console.log("this.loc = " + this.loc);
        console.log("-----------------------------------");
    }

    eventclicked() {
        if (this.loc === undefined)
            this.loc = "Im a local variable";
        console.log("I make it through the function");
        console.log("this.context = " + this.context);
        console.log("this.loc = " + this.loc);
        console.log("-----------------------------------");
        this.context.innerHTML = this.name + " " + this.loc;

    }
}