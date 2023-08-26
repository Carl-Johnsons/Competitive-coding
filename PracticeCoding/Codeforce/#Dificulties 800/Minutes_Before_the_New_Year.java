
//https://codeforces.com/problemset/problem/1283/A
import java.util.Scanner;

public class Minutes_Before_the_New_Year {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int hh, mm, midnight = 24 * 60;
            hh = sc.nextInt();
            mm = sc.nextInt();
            System.out.print(midnight - (hh * 60 + mm));
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
