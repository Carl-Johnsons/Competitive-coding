export default class CustomDay extends Date {

    getDateFormat() {
        return String(super.getDate()).padStart(2, 0) + "/" + String(super.getMonth() + 1).padStart(2, 0) + "/" + String(super.getFullYear());
    }
    setAllAttr(dd, mm, yyyy) {
        super.setFullYear(yyyy, mm, dd);
    }

    DateSum(date1, date2) {
        this.res = date1 + date2;
        return this.res;
    }
    DateDiff(date1, date2) {
        this.res = Math.abs(date1 - date2);
        return this.res;
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
    DaysToFullYear(value, mode) {
        if (mode === 0)
            value = this.MiliToDay(value);
        let y = 0,
            m = 0,
            w = 0,
            d = 0;
        let result, limit;
        while (value > 0) {
            limit = this.DayLimit(m + 1, y);
            if (value > limit) {
                value -= limit;
                m++;
                if (m === 12) {
                    y++;
                    m = 0;
                }
            } else if (value === limit) {
                m++;
                if (m === 12) {
                    y++;
                    m = 0;
                }
                value = 0;
            } else {
                w = Math.floor(value / 7);
                d = value % 7;
                value = 0;
            }
        }
        let year, month, week, day;
        year = (y > 1 ? y + " years " : y > 0 ? y + " year " : "");
        month = (m > 1 ? m + " months " : m > 0 ? m + " month " : "");
        week = (w > 1 ? w + " weeks " : w > 0 ? w + " week " : "");
        day = (d > 1 ? d + " days" : d > 0 ? d + " day" : "");
        result = year + "" + month + "" + week + "" + day;
        if (y === 0 && m === 0 && w === 0 && d === 0) {
            result = "Same date";
        }
        return result;
    }
    DayLimit(mm, yyyy) {
        let isLeapYear = false,
            daylimit;
        if (yyyy % 400 === 0 || (yyyy % 4 === 0 && yyyy % 100 != 0)) {
            isLeapYear = true;
        }
        switch (+mm) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daylimit = 31;
                break;
            case 2:
                daylimit = 28 + (isLeapYear ? 1 : 0);
                break;
            case 4:
            case 6:
            case 8:
            case 9:
            case 11:
                daylimit = 30;
                break;
        }
        return daylimit;
    }
}