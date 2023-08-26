
//https://codeforces.com/problemset/problem/1729/A
import java.util.Scanner;

public class Two_Elevators {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), time1 = 0, time2 = 0;
            time1 = a - 1;
            if (b > c) {
                time2 = b - 1;
            } else {
                time2 = (c - b) + (c - 1);
            }
            if (time1 > time2)
                System.out.print(2);
            else if (time1 < time2)
                System.out.print(1);
            else
                System.out.print(3);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
