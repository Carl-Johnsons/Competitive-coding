
//https://codeforces.com/problemset/problem/1551/A
import java.util.Scanner;

public class Polycarp_and_Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            long a, b, num = sc.nextLong();
            a = b = num / 3;
            if (num % 3 == 1)
                a++;
            else if (num % 3 == 2)
                b++;
            System.out.print(a + " " + b);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }

}
