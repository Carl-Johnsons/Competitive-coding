
//https://codeforces.com/problemset/problem/1303/A
import java.util.Scanner;

public class Erasing_Zeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            String str = sc.next();
            char[] s = str.toCharArray();
            int start = 0, end = 0, count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (s[i] == '1') {
                    start = i;
                    break;
                }
            }
            for (int i = str.length() - 1; i >= 0; i--) {
                if (s[i] == '1') {
                    end = i;
                    break;
                }
            }
            for (int i = start; i <= end; i++) {
                if (s[i] == '0' && start != end)
                    count++;
            }
            System.out.print(count);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
