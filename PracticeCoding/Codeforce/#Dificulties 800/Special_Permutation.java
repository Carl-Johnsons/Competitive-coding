
//https://codeforces.com/problemset/problem/1454/A
import java.util.Scanner;

public class Special_Permutation {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int n;
            n = sc.nextInt();
            System.out.print(n);
            for (int j = 1; j < n; j++)
                System.out.print(" " + j);
            if (i < testcase - 1)
                System.out.print("\n");

        }
        sc.close();
    }
}
