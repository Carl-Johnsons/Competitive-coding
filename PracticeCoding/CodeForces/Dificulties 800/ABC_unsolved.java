
//https://codeforces.com/problemset/problem/1632/A
import java.util.Scanner;

public class ABC_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int count[] = new int[2];
            int len = sc.nextInt();
            String str = sc.next();
            char[] s = str.toCharArray();
            for (int i = 0; i < len; i++) {
                int k = s[i] - (int) '0';
                count[k]++;
            }
            if ((count[0] > 1 && count[1] > 1) || (rev_equal(s) && len > 1))
                System.out.print("NO");
            else
                System.out.print("YES");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }

    public static boolean rev_equal(char a[]) {
        char rev[] = new char[a.length];
        int j = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            rev[i] = a[j];
            j++;
        }
        String r = new String(rev);
        String b = new String(a);
        if (r.equals(b))
            return true;
        else
            return false;

    }
}
