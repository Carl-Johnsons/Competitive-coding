
//https://codeforces.com/problemset/problem/1368/A
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long a = sc.nextLong(), b = sc.nextLong(), n = sc.nextLong(), count = 1, temp;
            if (a > b) {
                temp = a;
                a = b;
                b = temp;
            }
            while (a + b <= n) {
                a += b;
                count++;
                temp = a;
                a = b;
                b = temp;
            }
            System.out.print(count);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
