
//https://codeforces.com/problemset/problem/1650/A
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Deletions_of_Two_Adjacent_Letters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int char_location = -1;
            String str = sc.next();
            char s[] = str.toCharArray();
            char c = sc.next().toCharArray()[0];
            Set<Character> b = new HashSet<Character>();
            for (int i = 0; i < str.length(); i++) {
                b.add(s[i]);
                if (i % 2 == 0 && s[i] == c)
                    char_location = i;
            }
            if (!b.contains(c) || char_location < 0)
                System.out.print("NO");
            else
                System.out.print("YES");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
