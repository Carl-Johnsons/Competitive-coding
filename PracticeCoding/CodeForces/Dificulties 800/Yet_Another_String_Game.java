
//https://codeforces.com/problemset/problem/1480/A
import java.util.Scanner;

public class Yet_Another_String_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            String str = sc.next();
            char s[] = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if (i % 2 == 0) {
                    if (s[i] != 'a')
                        s[i] = 'a';
                    else
                        s[i]++;
                } else {
                    if (s[i] != 'z')
                        s[i] = 'z';
                    else
                        s[i]--;
                }
            }
            String a = new String(s);
            System.out.print(a);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
