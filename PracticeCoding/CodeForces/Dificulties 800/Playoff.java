
//https://codeforces.com/problemset/problem/1651/A
import java.util.Scanner;

public class Playoff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt();
            System.out.print(power(2, num) - 1);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }

    public static long power(long a, long b) {
        if (b == 0)
            return 1;
        else
            return power(a, b - 1) * a;
    }
}
