
//https://codeforces.com/problemset/problem/1579/A
import java.util.Scanner;

public class Casimir_s_String_Solitaire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            String str = sc.next();
            char[] s = str.toCharArray();
            int countA = 0, countB = 0, countC = 0;
            for (int j = 0; j < str.length(); j++) {
                if (s[j] == 'A')
                    countA++;
                else if (s[j] == 'B')
                    countB++;
                else
                    countC++;
            }
            if (countA + countC == countB)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
