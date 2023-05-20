public class Percentage_of_Letter_in_String {
    public static void main(String[] args) {
        String s = "foobar";
        char letter = 'o';
        System.out.println(percentageLetter(s, letter));
    }

    public static int percentageLetter(String s, char letter) {
        char str[] = s.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == letter) {
                count++;
            }
        }
        return count * 100 / str.length;
    }
}
