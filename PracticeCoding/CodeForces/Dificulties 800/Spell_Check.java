
//https://codeforces.com/problemset/problem/1722/A
import java.util.Scanner;

public class Spell_Check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt(), count;
            Boolean okay = true;
            String str = sc.next();
            char s[] = str.toCharArray(), mau[] = "Timur".toCharArray();
            if (len != 5)
                okay = false;
            else {
                for (int i = 0; i < 5; i++) {
                    count = 0;
                    for (int j = 0; j < 5; j++) {
                        if (mau[i] == s[j]) {
                            count++;
                        }
                    }
                    if (count != 1)
                        okay = false;
                    if (!okay)
                        break;
                }
            }
            if (okay)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();

        }
        sc.close();
    }
}
