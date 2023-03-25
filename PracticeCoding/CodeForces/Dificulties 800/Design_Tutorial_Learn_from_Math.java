
//https://codeforces.com/problemset/problem/472/A
import java.util.Scanner;

public class Design_Tutorial_Learn_from_Math {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextInt(), a = 0, b = 0, start = 4;
        a = start;
        b = num - start;
        while (isPrime(b)) {
            start += 2;
            a = start;
            b = num - start;
        }
        System.out.print(a + " " + b);
        sc.close();
    }

    public static boolean isPrime(long x) {
        int count = 0;
        for (int i = 2; i <= Math.sqrt((double) x); i++) {
            if (x % i == 0)
                count++;
        }
        if (count > 0)
            return false;
        else
            return true;
    }
}
