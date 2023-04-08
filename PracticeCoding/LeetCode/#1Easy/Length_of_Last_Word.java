public class Length_of_Last_Word {
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int len = 0;
        boolean endOfLastWord =false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isAlphabetic(s.charAt(i))) {
                len++;
                endOfLastWord = true;
            } else if (endOfLastWord) {
                break;
            }
        }
        return len;
    }
}
