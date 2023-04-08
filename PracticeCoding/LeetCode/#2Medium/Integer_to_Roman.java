import java.util.HashMap;
import java.util.Map;

public class Integer_to_Roman {

    public static void main(String[] args) {
        int x = 99;
        System.out.println(intToRoman(x));
    }

    public static String intToRoman(int num) {
        String res = "";

        int arr[] = new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String roman[] = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int initialKey = arr[0];
        int i = 0;
        while (num > 0) {
            if (num >= initialKey) {
                num -= initialKey;
                res += roman[i];
            } else {
                i++;
                initialKey = arr[i];
            }
        }
        return res;
    }

    public static int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
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
