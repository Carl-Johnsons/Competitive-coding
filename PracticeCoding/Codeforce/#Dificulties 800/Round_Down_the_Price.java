
//https://codeforces.com/problemset/problem/1702/A
import java.util.Scanner;

public class Round_Down_the_Price {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long num = sc.nextLong();
            long chuso = digit(num) - 1;
            System.out.print(num - pow(10, chuso));
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }

    public static long digit(long x) {
        long count = 0;
        while (x != 0) {
            x /= 10;
            count++;
        }
        return count;
    }

    public static long pow(long x, long y) {
        if (y == 0)
            return 1;
        else
            return pow(x, y - 1) * x;
    }
}
