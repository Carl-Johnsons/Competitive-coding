
//https://codeforces.com/problemset/problem/1807/B
import java.util.Scanner;

public class Grab_the_Candies {
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
        int len = sc.nextInt();
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < len; i++) {
            int value = sc.nextInt();
            if (value % 2 == 0) {
                sumEven += value;
            } else {
                sumOdd += value;
            }

        }
        if (sumEven > sumOdd) {
            res = "YES";
        } else {
            res = "NO";
        }
        System.out.println(res);
    }

}