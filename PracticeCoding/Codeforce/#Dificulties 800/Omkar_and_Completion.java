
//https://codeforces.com/problemset/problem/1372/A
import java.util.Scanner;

public class Omkar_and_Completion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                System.out.print(1);
                if (i < num - 1)
                    System.out.print(" ");
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
