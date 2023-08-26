
//https://codeforces.com/problemset/problem/1633/B
import java.util.Scanner;

public class Minority_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            String str = sc.next();
            char[] s = str.toCharArray();
            int count[] = new int[2], min, start = 0, end = 0;
            for (int i = 0; i < str.length() - 1; i++) {
                if (Math.abs(s[i] - s[i + 1]) == 1) {
                    start = i;
                    break;
                }
            }
            for (int i = str.length() - 1; i > start; i--) {
                if (Math.abs(s[i] - s[i - 1]) == 1) {
                    end = i;
                    break;
                }
            }
            if (start > 0)
                start--;
            else if (end < str.length() - 1)
                end++;
            for (int i = start; i <= end; i++) {
                int k = s[i] - (char) '0';
                count[k]++;
            }
            if (count[0] == count[1])
                min = 0;
            else if (count[0] > count[1])
                min = count[1];
            else
                min = count[0];
            System.out.print(min);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
