
//https://codeforces.com/problemset/problem/1223/A
import java.util.Scanner;

public class CME {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            long n = sc.nextLong();
            System.out.print(n == 2 ? 2 : n % 2);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
