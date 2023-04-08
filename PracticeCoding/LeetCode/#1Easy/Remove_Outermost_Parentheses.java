import java.util.Stack;

public class Remove_Outermost_Parentheses {
    public static void main(String[] args) {
        String s = "()()";
        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {
        String res = "";
        Stack<Character> stack = new Stack<>();
        int i = 0, j = 0;
        char c;
        while (i < s.length()) {
            c = s.charAt(i + j);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    res += (s.substring(i + 1, i + j));
                    i += (j + 1);
                    j = -1;
                }
            }
            j++;
        }
        return res;
    }
}