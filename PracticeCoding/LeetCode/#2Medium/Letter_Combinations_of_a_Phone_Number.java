import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();

        if (digits.isEmpty()) {
            return list;
        }

        Map<Integer, String> map = new HashMap<>();

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        backTracking(list, new StringBuilder(), digits, map, 0);
        return list;
    }

    public static void backTracking(
            List<String> list,
            StringBuilder str,
            String digits,
            Map<Integer, String> map,
            int start) {
        if (str.length() == digits.length()) {
            list.add(str.toString());
            return;
        }
        String current = map.get(digits.charAt(start) - '0');
        for (int i = 0; i < current.length(); i++) {
            str.append(current.charAt(i));
            backTracking(list, str, digits, map, start + 1);
            str.delete(str.length() - 1, str.length());
        }
    }

}
