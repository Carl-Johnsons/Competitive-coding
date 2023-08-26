
//https://codeforces.com/problemset/problem/1553/A
import java.util.Scanner;

public class Digits_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long num = sc.nextInt();
            System.out.print((num + 1) / 10);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
