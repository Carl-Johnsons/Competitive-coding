
//https://codeforces.com/problemset/problem/734/B
import java.util.Scanner;

public class Anton_and_Digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong(), d = sc.nextLong(), min, sum = 0;
        min = a;
        if (min > c)
            min = c;
        if (min > d)
            min = d;
        a -= min;
        sum += (256 * min);
        min = b;
        if (min > a)
            min = a;
        sum += (32 * min);
        System.out.print(sum);
        sc.close();
    }
}
