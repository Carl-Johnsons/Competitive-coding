export default class CustomDay extends Date {
    getDateFormat() {
        return String(super.getDate()).padStart(2, 0) + "/" + String(super.getMonth() + 1).padStart(2, 0) + "/" + String(super.getFullYear());
    }
    setAllAttr(dd, mm, yyyy) {
        super.setFullYear(yyyy, mm, dd);
    }

    DateSum(date1, date2) {
        this.res = date1 + date2;
        return this.MiliToDay(this.res);
    }
    DateDiff(date1, date2) {
        this.res = Math.abs(date1 - date2);
        return this.MiliToDay(this.res);
    }
    getResult() {
        return this.res;
    }
    getResultFormat() {
        let result = this.MiliToDay(this.res);
        let yyyy = result;
    }
    MiliToDay(value) {
        return value / 1000 / 60 / 60 / 24;
    }
}