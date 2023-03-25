
//https://codeforces.com/problemset/problem/1541/A
import java.util.Scanner;

public class Pretty_Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt();
            for (int i = 2; i <= num; i += 2) {
                if (num % 2 == 1 && i > num - 3) {
                    System.out.print(i + " " + (i + 1) + " " + (i - 1));
                } else if (i % 2 == 0)
                    System.out.print(i + " " + (i - 1));
                if (i <= num - 1)
                    System.out.print(" ");
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
