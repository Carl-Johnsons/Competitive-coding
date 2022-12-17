export default class test {
    constructor() {
        this.name = "lo";
        this.t();
    }
    t() {
        console.log(this.name);
        this.a();
    }
    a() {
        console.log(this.name + " too");
    }
}