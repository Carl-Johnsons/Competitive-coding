
//https://codeforces.com/problemset/problem/1675/A
import java.util.Scanner;

public class Food_for_Animals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong(), x = sc.nextLong(), y = sc.nextLong();
            if (x > a)
                c -= (x - a);
            if (y > b)
                c -= (y - b);
            if (c >= 0)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
