
//https://codeforces.com/problemset/problem/1517/A
import java.util.Scanner;

public class Sum_of_2050_time_limited_exceed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long num = sc.nextLong(), count = 0;
            long chuso = digit(num);
            boolean okay = true;
            if (num >= 2050) {
                while (num != 0) {
                    long temp = (2050 *(long) Math.pow((double)10, (double)(chuso - 4)));
                    num -= temp;
                    count++;
                    if (num == 0)
                        break;
                    else if (num < 0) {
                        okay = false;
                        break;
                    }
                    if (num < temp)
                        chuso--;
                }
            } else
                okay = false;
            if (okay)
                System.out.print(count);
            else
                System.out.print(-1);
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
}
