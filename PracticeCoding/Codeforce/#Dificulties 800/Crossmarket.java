
//https://codeforces.com/problemset/problem/1715/A
import java.util.Scanner;

public class Crossmarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            long hang = sc.nextLong(), cot = sc.nextLong(), min;
            min = hang;
            if (min > cot)
                min = cot;
            if (hang != 1 || cot != 1)
                System.out.print(hang + cot - 2 + min);
            else
                System.out.print(0);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
