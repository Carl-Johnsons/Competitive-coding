
//https://codeforces.com/problemset/problem/1369/A
import java.util.Scanner;

public class FashionabLee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            long n = sc.nextLong();
            if (n % 4 == 0)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
