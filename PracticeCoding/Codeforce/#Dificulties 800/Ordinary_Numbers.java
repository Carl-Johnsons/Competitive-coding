
//https://codeforces.com/problemset/problem/1520/B
import java.util.Scanner;

public class Ordinary_Numbers {
    public static void main(String[] args) {
        long testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextLong();
        for (long i = 0; i < testcase; i++) {
            long n, nearest_leftmost, nearest_digit, ordinary = 0, near_num;
            n = sc.nextLong();
            nearest_leftmost = (n / (long) Math.pow(10, (double) digit(n) - 1));
            nearest_digit = digit(n);
            near_num = nearest_ordinary_num(nearest_digit, nearest_leftmost);
            if (nearest_leftmost - 1 == 0 && n < near_num) {
                nearest_leftmost = 9;
                nearest_digit--;
            } else if (n < near_num)
                nearest_leftmost--;

            while (nearest_digit != 1) {
                ordinary += 9;
                nearest_digit--;
            }
            ordinary += nearest_leftmost;
            System.out.print(ordinary);
            if (i < testcase - 1)
                System.out.print("\n");

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

    public static long nearest_ordinary_num(long digit, long leftmost_num) {
        long sum = 0;
        while (true) {
            digit--;
            sum += Math.pow(10, (double) digit) * leftmost_num;
            if (digit == 0)
                break;
        }
        return sum;
    }
}
