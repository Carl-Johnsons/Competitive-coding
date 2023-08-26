
//https://codeforces.com/problemset/problem/1567/A
import java.util.Scanner;

public class Domino_Disaster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt();
            String str = sc.next();
            char[] s = str.toCharArray();
            for (int i = 0; i < len; i++) {
                if (s[i] == 'U')
                    s[i] = 'D';
                else if (s[i] == 'D')
                    s[i] = 'U';
            }
            String a = new String(s);
            System.out.print(a);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
