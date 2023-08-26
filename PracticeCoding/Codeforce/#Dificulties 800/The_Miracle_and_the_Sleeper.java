
//https://codeforces.com/problemset/problem/1562/A

import java.util.Scanner;

public class The_Miracle_and_the_Sleeper {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.close();
    }

    static int res = 0;

    public static void solve() {
        int left = sc.nextInt();
        int right = sc.nextInt();

        int halfRight = Math.floorDiv(right, 2);
        res = (left > halfRight) ? right % left : right % (halfRight + 1);
        System.out.println(res);
    }

}