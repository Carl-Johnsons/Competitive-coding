
//https://codeforces.com/problemset/problem/1692/B
import java.util.Scanner;

public class Squares_and_Cubes {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static double res = 0;

    public static void solve() {
        int value = sc.nextInt();
        double squared_number =Math.pow(value, (double) 1 / 2);
        double cubed_number = Math.pow(value, (double) 1 / 3);
        double squared_and_cubed_number = Math.pow(value, (double) 1 / 6);

        // Handle the pow function return wrong answer because it's double
        if (!isNthRoot(value, 2, 0.0000001)) {
            squared_number = Math.floor(squared_number);
        }
        if (!isNthRoot(value, 3, 0.0000001)) {
            cubed_number = Math.floor(cubed_number);
        }
        // Because of 6th root, so the precision must be very small
        if (!isNthRoot(value, 6, 0.000000001)) {
            squared_and_cubed_number = Math.floor(squared_and_cubed_number);
        }
        res = squared_number + cubed_number - squared_and_cubed_number;
        System.out.printf("%.0f\n", res);
    }

    private static boolean isNthRoot(int value, int n, double precision) {
        double a = Math.pow(value, 1.0 / n);
        return Math.abs(a - Math.round(a)) < precision; // if a and round(a) are "close enough" then we're good
    }
}
