
//https://codeforces.com/problemset/problem/1721/A
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Image {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            Set<Character> b = new HashSet<Character>();
            for (int i = 0; i < 2; i++) {
                String str = sc.next();
                char[] s = str.toCharArray();
                for (int j = 0; j < 2; j++) {
                    b.add(s[j]);
                }
            }
            System.out.print(b.size() - 1);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
