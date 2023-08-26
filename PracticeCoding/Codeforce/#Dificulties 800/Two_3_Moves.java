
//https://codeforces.com/problemset/problem/1716/A
import java.util.Scanner;

public class Two_3_Moves {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long num = sc.nextLong(), result = 0, nearest_int = 0;
            if (num == 1) {
                result = 2;
            } else if (num % 3 == 0) {
                result = num / 3;
            } else {
                nearest_int = num + (3 - num % 3);
                result = nearest_int / 3;
            }
            System.out.print(result);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
