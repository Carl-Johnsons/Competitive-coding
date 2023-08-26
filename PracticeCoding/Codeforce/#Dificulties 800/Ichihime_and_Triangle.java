
//https://codeforces.com/problemset/problem/1337/A
import java.util.Scanner;

public class Ichihime_and_Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testcase = sc.nextLong();
        for (long i = 0; i < testcase; i++) {
            long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong(), d = sc.nextLong();
            if (b == c)
                System.out.print(b + " " + b + " " + b);
            else
                System.out.print(b + " " + c + " " + c);
            if (i < testcase - 1)
                System.out.println();
            // avoid "The value of the local variable a,d is not used"
            a = d - 1;
            d = a - 1;
        }
        sc.close();
    }
}
