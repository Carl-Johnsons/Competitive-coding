
//https://codeforces.com/problemset/problem/1389/A
import java.util.Scanner;

public class LCM_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testcase = sc.nextLong();
        for (long i = 0; i < testcase; i++) {
            long l = sc.nextLong(), r = sc.nextLong();
            if (l * 2 <= r)
                System.out.print(l + " " + (l * 2));
            else
                System.out.print(-1 + " " + -1);
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
