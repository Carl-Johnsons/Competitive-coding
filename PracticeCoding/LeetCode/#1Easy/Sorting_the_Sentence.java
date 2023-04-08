public class Sorting_the_Sentence {
    public static void main(String[] args) {
        String s = "Myself2 Me1 I4 and3";
        System.out.println(sortSentence(s));
    }

    public static String sortSentence(String s) {
        String splStr[] = s.split(" ");
        String sorted = "", temp = "";
        int a, b;
        for (int i = 0; i < splStr.length; i++) {
            for (int j = i + 1; j < splStr.length; j++) {
                a = (int) (splStr[i].charAt(splStr[i].length() - 1)) - '0';
                b = (int) (splStr[j].charAt(splStr[j].length() - 1)) - '0';
                if (a > b) {
                    temp = splStr[i];
                    splStr[i] = splStr[j];
                    splStr[j] = temp;
                }
            }
        }
        for (int i = 0; i < splStr.length; i++) {
            sorted += splStr[i].substring(0, splStr[i].length() - 1);
            if (i < splStr.length - 1) {
                sorted += " ";
            }
        }
        return sorted;
    }
}
