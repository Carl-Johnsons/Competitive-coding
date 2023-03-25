
//https://codeforces.com/problemset/problem/1077/A
import java.util.Scanner;

public class Frog_Jumping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long a = sc.nextLong(), b = sc.nextLong(), k = sc.nextLong(), num_a, num_b;
            num_a = num_b = k / 2;
            if (k % 2 == 1)
                num_a++;
            System.out.print(a * num_a - b * num_b);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
