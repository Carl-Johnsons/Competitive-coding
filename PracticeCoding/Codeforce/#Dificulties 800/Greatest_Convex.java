//https://codeforces.com/problemset/problem/1768/A

import java.util.Scanner;

public class Greatest_Convex {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            solve();
        }
        sc.close();
    }

    static int res = 0;

    public static void solve() {
        int num = sc.nextInt();
        res = num - 1;
        System.out.println(res);
    }

}