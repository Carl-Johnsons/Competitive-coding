
//https://codeforces.com/problemset/problem/822/A
import java.util.Scanner;

public class I_m_bored_with_life {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong(), min = 0;
        min = a;
        if (min > b) {
            min = b;
        }
        System.out.print(factorial(min));
        sc.close();
    }

    public static long factorial(long x) {
        if (x == 1)
            return 1;
        else
            return factorial(x - 1) * x;
    }
}
