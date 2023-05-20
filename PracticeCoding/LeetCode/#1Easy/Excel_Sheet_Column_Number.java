public class Excel_Sheet_Column_Number {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
    }

    public static int titleToNumber(String columnTitle) {
        int value = 0;
        int exponent = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            value += (int) ((columnTitle.charAt(i) - 'A') + 1) * (int) Math.pow(26, exponent);
            exponent++;
        }
        return value;
    }
}
