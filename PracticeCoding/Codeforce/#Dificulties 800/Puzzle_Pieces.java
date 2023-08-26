
//https://codeforces.com/problemset/problem/1345/A
import java.util.Scanner;

public class Puzzle_Pieces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int a = sc.nextInt(), b = sc.nextInt();

            if ((a == 2 && b == 2) || (a == 1) || (b == 1))
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
