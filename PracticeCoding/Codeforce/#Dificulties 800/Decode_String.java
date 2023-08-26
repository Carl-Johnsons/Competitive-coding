
//https://codeforces.com/problemset/problem/1729/B
import java.util.Scanner;

public class Decode_String {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    public static void solve() {
        int len = Integer.parseInt(sc.nextLine());
        String code = sc.nextLine();
        String res = "";
        for (int i = code.length() - 1; i >= 0; i--) {
            char value;
            if (code.charAt(i) == '0') {
                value = (char) (Integer.parseInt(code.substring(i - 2, i)) - 1 + 'a');
                i -= 2;
            } else {
                value = (char) (Integer.parseInt(code.substring(i, i + 1)) - 1 + 'a');
            }
            res = value + res;
        }
        System.out.println(res);
    }

}
