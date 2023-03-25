
//https://codeforces.com/problemset/problem/1312/A
import java.util.Scanner;

public class Two_Regular_Polygons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt(), num2 = sc.nextInt();
            if (num % num2 == 0 || num2 % num == 0)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
