
//https://codeforces.com/problemset/problem/1481/A
import java.util.Scanner;

public class Space_Navigation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            String result = "NO";
            int x_fin = sc.nextInt(), y_fin = sc.nextInt(), count[] = new int[27];
            String str = sc.next();
            char s[] = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if (s[i] != 'L' && s[i] != 'D')
                    count[s[i] - (int) 'A']++;
                else
                    count[s[i] - (int) 'A']--;
            }
            if (x_fin >= 0 && count['R' - (int) 'A'] >= x_fin) {
                if (y_fin >= 0 && count['U' - (int) 'A'] >= y_fin || y_fin < 0 && count['D' - (int) 'A'] <= y_fin)
                    result = "YES";
            } else if (x_fin <= 0 && count['L' - (int) 'A'] <= x_fin) {
                if (y_fin >= 0 && count['U' - (int) 'A'] >= y_fin || y_fin < 0 && count['D' - (int) 'A'] <= y_fin)
                    result = "YES";
            }
            System.out.print(result);
            if (testcase > 0)
                System.out.println();
        }

        sc.close();
    }

}
