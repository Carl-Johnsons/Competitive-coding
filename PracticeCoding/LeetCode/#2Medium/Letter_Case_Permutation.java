import java.util.LinkedList;
import java.util.List;

public class Letter_Case_Permutation {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(letterCasePermutation(s));
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> list = new LinkedList<>();
        s = s.toLowerCase();
        backTracking(list, s.toCharArray(), 0);
        return list;
    }

    public static void backTracking(
            List<String> list,
            char[] s,
            int start) {
        list.add(String.valueOf(s));
        for (int i = start; i < s.length; i++) {
            if (!(s[i] >= 'a' && s[i] <= 'z')) {
                continue;
            }
            s[i] -= 32; // explore
            backTracking(list, s, i + 1);
            s[i] += 32;// failed lui
        }
    }
}
