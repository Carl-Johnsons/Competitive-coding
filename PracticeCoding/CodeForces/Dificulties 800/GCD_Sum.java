
//https://codeforces.com/problemset/problem/1498/A
import java.util.Scanner;

public class GCD_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            long n = sc.nextLong();
            for (long i = n; i <= n + 2; i++) {
                long temp = gcd_sum(i);
                if (temp > 1) {
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    public static long gcd_sum(long num) {
        long temp = num;
        long sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return gcd(num, sum);
    }

}
