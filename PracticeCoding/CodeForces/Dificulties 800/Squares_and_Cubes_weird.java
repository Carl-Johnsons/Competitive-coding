
//https://codeforces.com/problemset/problem/1619/B
import java.util.Scanner;

public class Squares_and_Cubes_weird {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long num = sc.nextLong(), square = 0, cube = 0, both_square_and_cube = 0;
            square = (long) Math.pow(num, (double) 1 / 2);
            both_square_and_cube = (long) Math.pow(num, (double) 1 / 6);
            cube = (long) (Math.pow(num, (double) 1 / 3));
            double test = (Math.pow(num, (double) 1 / 3));

            if (cube == (long) test)
                System.out.println("YES");
            else
                System.out.println("NO");

            System.out.print((square + test - both_square_and_cube));
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
