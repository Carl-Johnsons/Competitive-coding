
//https://codeforces.com/problemset/problem/1550/A
import java.util.Scanner;

public class Find_The_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt();
            int maxle = 0, sole = 0, count = 0, sum_le = 0;
            while (sum_le < num) {
                maxle = 1 + 2 * sole;
                sum_le += maxle;
                count++;
                sole++;
            }
            System.out.print(count);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
