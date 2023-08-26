
// https://codeforces.com/problemset/problem/1374/A
import java.util.Scanner;

public class Required_Remainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            long x, y, n, temp, result = 0;
            x = sc.nextLong();
            y = sc.nextLong();
            n = sc.nextLong();
            temp = n / x;
            for (long j = temp; j >= 0; j--) {
                result = x * j + y;
                if (result <= n) {
                    break;
                }
            }
            System.out.print(result);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}