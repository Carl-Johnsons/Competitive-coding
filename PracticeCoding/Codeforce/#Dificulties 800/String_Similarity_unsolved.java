
//https://codeforces.com/problemset/problem/1400/A
import java.util.Scanner;

public class String_Similarity_unsolved {
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
        res = "";
        int len = Integer.parseInt(sc.nextLine());
        String binary_str = sc.nextLine();
        for (int i = 0; i < binary_str.length() - len + 1; i++) {
            res += binary_str.charAt(i + len - 1) + "";
        }
        System.out.println("res:" + res);
    }

}