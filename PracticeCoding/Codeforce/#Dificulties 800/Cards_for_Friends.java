
//https://codeforces.com/problemset/problem/1472/A
import java.util.Scanner;

public class Cards_for_Friends {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int width, height, friends, sheets = 1, mul;
            width = sc.nextInt();
            height = sc.nextInt();
            friends = sc.nextInt();
            mul = width * height;
            if (mul % 2 == 0) {
                while (mul % 2 == 0) {
                    mul /= 2;
                    sheets *= 2;
                }
            }
            if (sheets >= friends)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
