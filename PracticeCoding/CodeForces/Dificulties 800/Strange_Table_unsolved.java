
//https://codeforces.com/problemset/problem/1506/A
import java.util.Scanner;

public class Strange_Table_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long n, m, x, result = 0, remainder = 0, division = 0;
            n = sc.nextLong();
            m = sc.nextLong();
            x = sc.nextLong();
            remainder = x % n;
            if (n != 1 && m != 1) {
                if (remainder != 0)
                    result += (remainder - 1) * m;
                else
                    result = m;
                division = x / n;   
                if (remainder != 0)
                    result += (division + 1);
                else if (x == m * n)
                    result *= n;
                else
                    result += 1;
            } else
                result = x;
            System.out.print(result);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
