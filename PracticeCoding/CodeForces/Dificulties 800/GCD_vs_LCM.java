
//https://codeforces.com/problemset/problem/1665/A
import java.util.Scanner;

public class GCD_vs_LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            System.out.print(1 + " " + (sc.nextLong() - 3) + " " + 1 + " " + 1);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
