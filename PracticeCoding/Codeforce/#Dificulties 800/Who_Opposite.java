
//https://codeforces.com/problemset/problem/1560/B
import java.util.Scanner;

public class Who_Opposite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testcase = sc.nextLong();
        for (long i = 0; i < testcase; i++) {
            long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong(), circle = 0, opposite = 0;
            circle = Math.abs(a - b) * 2;
            if (c > circle || circle / 2 == 1 || a > circle || b > circle)
                System.out.print(-1);
            else {
                opposite = c + circle / 2;
                if (opposite > circle)
                    opposite = c - circle / 2;
                System.out.print(opposite);
            }
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
