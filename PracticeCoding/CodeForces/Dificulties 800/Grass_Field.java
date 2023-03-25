
//https://codeforces.com/problemset/problem/1701/A
import java.util.Scanner;

public class Grass_Field {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            boolean has_zero = false, has_one = false;
            int arr[][] = new int[2][2];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                    if (arr[i][j] == 0)
                        has_zero = true;
                    else if (arr[i][j] == 1)
                        has_one = true;
                }
            }
            if (has_one && !has_zero)
                System.out.print(2);
            else if (has_one && has_zero)
                System.out.print(1);
            else
                System.out.print(0);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
