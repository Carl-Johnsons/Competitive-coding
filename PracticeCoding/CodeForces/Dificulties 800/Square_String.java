
//https://codeforces.com/problemset/problem/1619/A
import java.util.Scanner;

public class Square_String {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            boolean notSquare;
            String s = sc.next(), substr1, substr2;
            if (s.length() % 2 == 1)
                notSquare = true;
            else {
                if (s.length() > 2) {
                    substr1 = s.substring(0, (s.length() / 2) );
                    substr2 = s.substring(s.length() / 2, s.length());
                    if (substr1.compareTo(substr2) == 0)
                        notSquare = false;
                    else
                        notSquare = true;
                } else {
                    if (s.charAt(0) == s.charAt(1))
                        notSquare = false;
                    else
                        notSquare = true;
                }
            }
            if (notSquare)
                System.out.print("NO");
            else
                System.out.print("YES");
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
