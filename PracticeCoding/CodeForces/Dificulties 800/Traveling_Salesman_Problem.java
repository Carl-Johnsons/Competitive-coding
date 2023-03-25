
//https://codeforces.com/contest/1713/problem/A
import java.util.Scanner;

public class Traveling_Salesman_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int x_duong_max = 0, x_am_max = 999, y_duong_max = 0, y_am_max = 999;
            int len = sc.nextInt();
            for (int i = 0; i < len; i++) {
                int x = sc.nextInt(), y = sc.nextInt();
                if (x == 0) {
                    if (y > 0 && y_duong_max < y)
                        y_duong_max = y;
                    else if (y < 0 && y_am_max > y)
                        y_am_max = y;
                } else if (y == 0) {
                    if (x > 0 && x_duong_max < x)
                        x_duong_max = x;
                    else if (x < 0 && x_am_max > x)
                        x_am_max = x;
                }
            }
            if (x_am_max == 999)
                x_am_max = 0;
            if (y_am_max == 999)
                y_am_max = 0;
            System.out.print((x_duong_max - x_am_max + (y_duong_max - y_am_max)) * 2);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}