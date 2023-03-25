
//https://codeforces.com/problemset/problem/1234/A
import java.util.Scanner;

public class Equalize_Prices_Again {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int n = sc.nextInt();
            long sum = 0, result;
            for (int i = 0; i < n; i++) {
                long k = sc.nextLong();
                sum += k;
            }
            result = sum / n;
            if (result * n < sum)
                result = (sum / n) + 1;
            System.out.print(result);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
