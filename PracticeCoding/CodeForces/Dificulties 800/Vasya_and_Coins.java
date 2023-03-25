
//https://codeforces.com/problemset/problem/1660/A
import java.util.Scanner;

public class Vasya_and_Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            long a = sc.nextLong(), b = sc.nextLong();
            if (a == 0)
                System.out.print(1);
            else {
                System.out.print(a + b * 2 + 1);
            }
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
