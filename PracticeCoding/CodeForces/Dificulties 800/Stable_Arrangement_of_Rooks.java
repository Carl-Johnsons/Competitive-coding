
//https://codeforces.com/problemset/problem/1621/A
import java.util.Scanner;

public class Stable_Arrangement_of_Rooks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int n = sc.nextInt(), rooks = sc.nextInt(), hang = 0;
            if ((n / 2) + (n % 2) >= rooks) {
                char s[][] = new char[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        s[i][j] = '.';
                    }
                }
                while (rooks-- != 0) {
                    s[hang][hang] = 'R';
                    hang += 2;
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(s[i][j]);
                    }
                    if (i < n - 1)
                        System.out.println();
                }
            } else
                System.out.print(-1);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
