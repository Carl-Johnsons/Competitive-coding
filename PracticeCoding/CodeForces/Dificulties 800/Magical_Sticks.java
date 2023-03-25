
//https://codeforces.com/problemset/problem/1371/A
import java.util.Scanner;

public class Magical_Sticks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int n;
            n = sc.nextInt();
            if (n % 2 == 1)
                System.out.print((n / 2) + 1);
            else
                System.out.print(n / 2);
            if (i < testcase)
                System.out.print("\n");
        }
        sc.close();
    }

}
