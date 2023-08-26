
//https://codeforces.com/problemset/problem/1360/A
import java.util.Scanner;

public class Minimal_Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int a, b, min = 0, max = 0, S = 0;
            a = sc.nextInt();
            b = sc.nextInt();
            min = a;
            max = b;
            if (min > b) {
                min = b;
                max = a;
            }
            if (min * 2 <= max)
                S = power(max, 2);
            else if (min * 2 > max)
                S = power(min * 2, 2);
            System.out.print(S);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }

    public static int power(int x, int y) {
        if (y == 0)
            return 1;
        else
            return power(x, y - 1) * x;
    }
}
