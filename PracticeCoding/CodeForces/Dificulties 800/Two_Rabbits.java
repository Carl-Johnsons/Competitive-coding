
//https://codeforces.com/problemset/problem/1304/A
import java.util.Scanner;

public class Two_Rabbits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long result = -1, x = sc.nextLong(), y = sc.nextLong(), a = sc.nextLong(), b = sc.nextLong();
            if ((y - x) % (a + b) == 0)
                result = (y - x) / (a + b);
            System.out.print(result);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
