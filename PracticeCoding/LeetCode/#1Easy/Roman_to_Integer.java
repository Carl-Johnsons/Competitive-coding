//https://leetcode.com/problems/roman-to-integer/submissions/927973263/
import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer {
    static Map<Character, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        int res = 0;
    
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = map.get(s.charAt(i));
            if (sum != 1000 && i + 1 < s.length()) {
                if (map.get(s.charAt(i + 1)) > sum) {
                    sum = map.get(s.charAt(i + 1)) - sum;
                    i++;
                }
            }
            res += sum;
        }

        return res;
    }
}
