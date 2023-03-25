
//https://codeforces.com/problemset/problem/1353/A
import java.util.Scanner;

public class Most_Unstable_Array {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            long n, m, max;
            n = sc.nextLong();
            m = sc.nextLong();
            if (n == 1)
                max = 0;
            else if (n == 2)
                max = m;
            else {
                max = m * 2;
            }
            System.out.print(max);
            if (i < testcase - 1)
                System.out.print("\n");

        }
        sc.close();
    }

}
