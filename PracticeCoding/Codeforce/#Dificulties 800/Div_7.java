
//https://codeforces.com/problemset/problem/1633/A
import java.util.Scanner;

public class Div_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt(), chuso, result, not_donvi;
            not_donvi = num / 10;
            chuso = digit(num);
            result = (num / 7) * 7;
            if (digit(result) < chuso || not_donvi != result / 10)
                result = ((num / 7) + 1) * 7;
            System.out.print(result);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }

    public static int digit(int x) {
        int count = 0;
        while (x != 0) {
            x /= 10;
            count++;
        }
        return count;
    }
}
