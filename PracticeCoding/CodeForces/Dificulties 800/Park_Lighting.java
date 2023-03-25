
//https://codeforces.com/problemset/problem/1358/A
import java.util.Scanner;

public class Park_Lighting {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int row = sc.nextInt(), col = sc.nextInt(), total_square, total_light;
            total_square = row * col;
            total_light = total_square / 2;
            if (total_square % 2 == 1)
                total_light++;
            System.out.print(total_light);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
