
//https://codeforces.com/problemset/problem/1702/B
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Polycarp_Writes_a_String_from_Memory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            String str = sc.next();
            char[] s = str.toCharArray();
            Set<Character> c = new HashSet<Character>();
            int days = 0;
            for (int i = 0; i < str.length(); i++) {
                while (true) {
                    c.add(s[i]);
                    if (i == str.length() - 1 || i < str.length() - 1 && !c.contains(s[i + 1]) && c.size() == 3)
                        break;
                    i++;
                }
                c.clear();
                days++;
            }
            System.out.print(days);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
