
//https://codeforces.com/problemset/problem/214/A
import java.util.Scanner;

public class System_of_Equations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (pow(i, 2) + j == n && i + pow(j, 2) == m) {
                    count++;
                }
            }
        }
        System.out.print(count);
        sc.close();
    }

    public static int pow(int x, int y) {
        if (y == 0)
            return 1;
        else
            return pow(x, y - 1) * x;
    }
}
