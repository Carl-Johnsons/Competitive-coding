
//https://codeforces.com/problemset/problem/1729/B
import java.util.Scanner;

public class Decode_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int len = sc.nextInt();
            String str = sc.next();
            char[] s = str.toCharArray();
            for (int i = 0; i < len; i++) {
                if (i >= len - 2) {
                    int k = Integer.parseInt(str.substring(i, i + 1));
                    System.out.print((char) (k + (int) 'a' - 1));
                } else if (s[i + 2] != '0') {
                    int k = Integer.parseInt(str.substring(i, i + 1));
                    System.out.print((char) (k + (int) 'a' - 1));
                } else if ((i < len - 2) && (s[i + 2] != '0') || (i < len - 3 && s[i + 3] != '0')) {
                    int num = Integer.parseInt(str.substring(i, i + 2));
                    System.out.print((char) (num + (int) 'a' - 1));
                    i += 2;
                } else {
                    int k = Integer.parseInt(str.substring(i, i + 1));
                    System.out.print((char) (k + (int) 'a' - 1));
                }
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
