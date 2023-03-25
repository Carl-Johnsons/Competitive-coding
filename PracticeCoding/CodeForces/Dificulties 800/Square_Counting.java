
//https://codeforces.com/problemset/problem/1646/A
import java.util.Scanner;

public class Square_Counting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            long n = sc.nextLong(), s = sc.nextLong();
            System.out.print(s / (n * n));
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
