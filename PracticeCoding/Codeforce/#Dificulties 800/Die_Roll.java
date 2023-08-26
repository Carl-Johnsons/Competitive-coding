
//https://codeforces.com/problemset/problem/9/A
import java.util.Scanner;

public class Die_Roll {
    public static void main(String[] args) {
        int a, b, max, Dot_win = 0, UCLN;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        max = a;
        if (max < b)
            max = b;
        Dot_win = 6 - max + 1;
        UCLN = gcd(Dot_win, 6);
        if ((double) Dot_win / 6 == 0)
            System.out.print("0/1");
        else
            System.out.print(Dot_win / UCLN + "/" + 6 / UCLN);
        sc.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
}
