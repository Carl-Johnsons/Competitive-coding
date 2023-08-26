
//https://codeforces.com/problemset/problem/599/A
import java.util.Scanner;

public class Patrick_and_Shopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong(), sum = 0;
        sum += min(a, b);
        if (sum == a) {
            sum += min(a + b, c);
            sum += min(a + c, b);
        } else if (sum == b) {
            sum += min(c, b + a);
            sum += min(a, b + c);
        }
        System.out.print(sum);
        sc.close();
    }

    public static long min(long x, long y) {
        long m = x;
        if (m > y)
            m = y;
        return m;
    }
}
