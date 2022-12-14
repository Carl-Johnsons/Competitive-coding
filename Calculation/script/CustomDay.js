export default class CustomDay {

    constructor(day, month, year) {
        let today = new Date();
        if (day === undefined) {
            this.day = String(today.getDate()).padStart(2, 0);
        } else {
            this.day = day;
        }
        if (month === undefined) {
            this.month = String(today.getMonth()).padStart(2, 0);
        } else {
            this.month = month;
        }
        if (year === undefined) {
            this.year = String(today.getFullYear()).padStart(4, 0);
        } else {
            this.year = year;
        }

    }
    getDay() {
        return this.day;
    }
    getMonth() {
        return this.month;
    }
    getYear() {
        return this.year;
    }
    setDay(day) {
        this.day = String(day.toString()).padStart(2, 0);
    }
    setMonth(month) {
        this.month = String(month.toString()).padStart(2, 0);
    }
    setYear(year) {
        this.year = String(year.toString()).padStart(4, 0);
    }
    getDateFormat() {
        return this.day + "/" + this.month + "/" + this.year;
    }
    setDateFormat(Date) {
        this.day = Date.day;
        this.month = Date.month;
        this.year = Date.year;
    }
    setAllAttr(dd, mm, yyyy) {
        this.day = dd;
        this.month = mm;
        this.year = yyyy;
    }
}