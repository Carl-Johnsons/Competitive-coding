public class Repeated_Substring_Pattern {
    public static void main(String[] args) {
        String s = "babbabbabbabbab";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int step = s.length() / 2, i;
        i = 0;
        while (!s.substring(i, step).equals(s.substring(s.length() - step, s.length()))) {
            step--;
        }
        String pattern = s.substring(i, step);
        if (step == 0 || pattern.length() > s.length() / 2) {
            return false;
        }
        while (i + step < s.length()) {
            if (!pattern.equals(s.substring(i, i + step))) {
                return false;
            }
            i += step;
        }
        return true;
    }

}
