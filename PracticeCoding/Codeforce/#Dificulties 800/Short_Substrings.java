
//https://codeforces.com/problemset/problem/1367/A
import java.util.Scanner;

public class Short_Substrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            String str = sc.next();
            int j = 0;
            if (str.length() >= 4) {
                char s[] = str.toCharArray(), result[] = new char[str.length() - ((str.length() - 2) / 2)];
                for (int i = 0; i < str.length(); i++) {
                    result[j] = s[i];
                    if (i != 0 || i != str.length() - 1) {
                        i++;
                    }
                    j++;
                }
                result[j] = s[str.length() - 1];
                String a = new String(result);
                System.out.print(a);
            } else
                System.out.print(str);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
