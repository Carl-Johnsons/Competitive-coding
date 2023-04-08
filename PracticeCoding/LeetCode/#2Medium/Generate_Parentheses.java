import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Generate_Parentheses {
    static Stack<Character> stack;
    static Map<Character, Character> map;

    public static void main(String[] args) {
        System.out.println(generateParenthesis(8));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        stack = new Stack<>();
        map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        String str = "";

        for (int i = 0; i < n * 2; i++) {
            str += "(";
        }
        backTracking(list, str, 0);

        return list;
    }

    static int count = 0;

    public static boolean backTracking(List<String> list, String str, int i) {
        if (isValid(str)) {
            list.add(str);
            return true;
        }
        if (i >= str.length() * 2) {
            return false;
        }
        char[] s = str.toCharArray();
        for (int j = i; j < str.length(); j++) {
            if (isValidPlacement(str, j, count)) {
                s[j] = ')';
                count++;
                str = String.valueOf(s);
                backTracking(list, str, j + 1);
            }
            count--;
            s[j] = '(';
            str = String.valueOf(s);

        }
        return false;
    }

    public static boolean isValidPlacement(String s, int j, int count) {
        return (count < s.length() / 2 || isValid(s, j)) && j > count;

    }

    public static boolean isValid(String s, int j) {
        String temp = new String(s);
        char[] a = temp.toCharArray();
        a[j] = '(';
        temp = String.valueOf(j);

        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || c != map.get(stack.pop())) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            stack.clear();
            return false;
        }
        return true;
    }

    public static boolean isValid(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || c != map.get(stack.pop())) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            stack.clear();
            return false;
        }
        return true;
    }
}
