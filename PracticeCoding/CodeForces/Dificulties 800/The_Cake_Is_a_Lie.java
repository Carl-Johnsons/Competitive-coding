
//https://codeforces.com/problemset/problem/1519/B
import java.util.Scanner;

public class The_Cake_Is_a_Lie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            int move_down = a - 1, move_right = a * (b - 1);
            if (move_down + move_right == c)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
