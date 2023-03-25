
//https://codeforces.com/problemset/problem/1325/A
import java.util.Scanner;

public class EhAb_AnD_gCd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testcase = sc.nextLong();
        for (long i = 0; i < testcase; i++) {
            long x = sc.nextLong();
            x--;
            System.out.print(1 + " " + x);
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }

    public static long GCD(long a, long b) {
        if (b == 0)
            return a;
        else
            return GCD(b, a % b);
    }

    public static long LCM(long a, long b) {
        return (a * b) / GCD(a, b);
    }
}
