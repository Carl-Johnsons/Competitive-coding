public class Excel_Sheet_Column_Title {
    public static void main(String[] args) {
        System.out.println(convertToTitle(78));
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber  > 0) {
            sb.insert(0, ((char) ((((--columnNumber) % 26)) + 'A') + ""));
            columnNumber /= 26;
        }
        return sb.toString();
    }
}
