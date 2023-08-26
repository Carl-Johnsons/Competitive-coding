
//https://codeforces.com/problemset/problem/1525/A
import java.util.Scanner;

public class Potion_making {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt();
            System.out.print(100 / gcd(num, 100 - num));
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
