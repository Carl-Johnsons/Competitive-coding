
//https://codeforces.com/problemset/problem/1632/A
import java.util.Scanner;

public class ABC {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static String res = "";

    public static void solve() {
        int len = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        if (str.length() <= 2) {
            if (str.length() == 1 || !isPalindrome(str)) {
                res = "YES";
            } else
                res = "NO";
        } else {
            res = "NO";
        }
        System.out.println(res);
    }

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (start >= end) {
                break;
            }
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

}
