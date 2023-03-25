
//https://codeforces.com/problemset/problem/1554/A
import java.util.Scanner;

public class Cherry_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int n = sc.nextInt();
            long arr[] = new long[n], max = 0, mul_max = 0, mul_left = 0, mul_right = 0, mul_max2 = 0;
            int max_loc = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                mul_left = 0;
                mul_right = 0;
                if (max <= arr[i]) {
                    max = arr[i];
                    max_loc = i;
                }
                if (max_loc > 0)
                    mul_left = arr[max_loc - 1] * max;
                if (max_loc < n - 1)
                    mul_right = arr[max_loc + 1] * max;
                mul_max = mul_left > mul_right ? mul_left : mul_right;
                if (mul_max2 < mul_max)
                    mul_max2 = mul_max;
            }
            System.out.print(mul_max2);
            if (testcase > 0)
                System.out.println();

        }
        sc.close();
    }
}
