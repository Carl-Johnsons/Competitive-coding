
//https://codeforces.com/problemset/problem/1549/A
import java.util.Scanner;

public class Gregor_and_Cryptography {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long num = sc.nextLong();
            System.out.print(2 + " " + (num - 1));
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
