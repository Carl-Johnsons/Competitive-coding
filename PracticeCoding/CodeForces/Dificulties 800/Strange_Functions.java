
//https://codeforces.com/problemset/problem/1455/A
import java.util.Scanner;

public class Strange_Functions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            String str = sc.next();
            System.out.print(str.length());
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
