
//https://codeforces.com/problemset/problem/1519/A
import java.util.Scanner;

public class Red_and_Blue_Beans_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong(), min, max;
            String result = "NO";
            min = a;
            max = a;
            if (min > b)
                min = b;
            if (max < b)
                max = b;
            if (c != 0) {
                if (max - c * min - 1 <= 1)
                    result = "YES";
            } else {
                if (a == b)
                    result = "YES";
            }
            System.out.print(result);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}