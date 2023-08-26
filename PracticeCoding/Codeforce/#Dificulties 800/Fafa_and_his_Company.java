
//https://codeforces.com/problemset/problem/935/A
import java.util.Scanner;

public class Fafa_and_his_Company {
    public static void main(String[] args) {
        int n, count = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0)
                count++;
        }
        System.out.print(count);
        sc.close();
    }
}
