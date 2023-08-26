
//https://codeforces.com/problemset/problem/1370/A
import java.util.Scanner;

public class Maximum_GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testcase;
        testcase = sc.nextInt();
        for (long i = 0; i < testcase; i++) {
            long number;
            number = sc.nextInt();
            System.out.print(number / 2);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
