
//https://codeforces.com/problemset/problem/1692/B
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class All_Distinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt();
            Set<Integer> a = new HashSet<Integer>();
            for (int i = 0; i < len; i++) {
                int k = sc.nextInt();
                a.add(k);
            }
            if (a.size() == len) {
                System.out.print(a.size());
            } else if (len > 2) {
                if (len % 2 == 0)
                    System.out.print(a.size());
                else
                    System.out.print(a.size() - 1);
            } else
                System.out.print(0);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
