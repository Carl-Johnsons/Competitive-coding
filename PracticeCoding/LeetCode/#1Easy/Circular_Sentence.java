public class Circular_Sentence {
    public static void main(String[] args) {
        String s = "Leetcode is cool";
        System.out.println(isCircularSentence(s));
    }

    public static boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1))
            return false;
        String splStr[] = sentence.split(" ");

        for (int i = 0; i < splStr.length - 1; i++) {
            if (splStr[i].charAt(splStr[i].length() - 1) != splStr[i + 1].charAt(0)) {
                return false;
            }
        }
        return true;

    }
}
