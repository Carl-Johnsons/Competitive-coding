
//https://codeforces.com/problemset/problem/1426/A
import java.util.Scanner;

public class Floor_Number {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int n, x, floors = 1;
            n = sc.nextInt();
            x = sc.nextInt();
            if (n > 2) {
                floors += ((n - 2) / x);
                if ((n - 2) % x != 0)
                    floors++;
            }
            System.out.print(floors);
            if (i < testcase - 1)
                System.out.print("\n");

        }
        sc.close();
    }
}
