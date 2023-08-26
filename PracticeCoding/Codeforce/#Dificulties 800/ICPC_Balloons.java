
//https://codeforces.com/problemset/problem/1703/B
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ICPC_Balloons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int balloons = 0, num = sc.nextInt();
            String str = sc.next();
            char s[] = str.toCharArray();
            Set<Character> b = new HashSet<Character>();
            for (int i = 0; i < num; i++) {
                if (b.contains(s[i])) {
                    balloons += 1;
                } else
                    balloons += 2;
                b.add(s[i]);

            }
            System.out.print(balloons);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
