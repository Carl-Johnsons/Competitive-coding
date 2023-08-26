
//https://codeforces.com/problemset/problem/1706/A
import java.util.Scanner;

public class Another_String_Minimization_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int n = sc.nextInt(), m = sc.nextInt();
            char s[] = new char[m];
            for (int i = 0; i < m; i++) {
                s[i] = 'B';
            }
            for (int i = 0; i < n; i++) {
                int loc1 = sc.nextInt() - 1;
                int loc2 = (m + 1 - loc1) - 2;
                if (s[loc1] == 'A' && s[loc2] == 'B')
                    s[loc2] = 'A';
                else if (s[loc1] == 'B' && s[loc2] == 'A')
                    s[loc1] = 'A';
                else
                    s[loc1 < loc2 ? loc1 : loc2] = 'A';
            }
            for (int i = 0; i < m; i++) {
                System.out.print(s[i]);
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
