
//https://codeforces.com/problemset/problem/1512/B
import java.util.Scanner;

public class Almost_Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt();
            int x1 = 0, x2 = 0, y1 = 0, y2 = 0, count = 0;
            String str[] = new String[len];
            for (int i = 0; i < len; i++) {
                str[i] = sc.next();
            }
            char s[][] = new char[len][];
            for (int i = 0; i < len; i++) {
                s[i] = str[i].toCharArray();
            }
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (s[i][j] == '*') {
                        if (count == 0) {
                            x1 = i;
                            y1 = j;
                        } else {
                            x2 = i;
                            y2 = j;
                        }
                        count++;
                    }
                }
                if (count == 2)
                    break;
            }
            if (y1 == y2) {
                if (y1 < len - 1 && y2 < len - 1) {
                    y1++;
                    y2++;
                } else if (y1 > 0 && y2 > 0) {
                    y1--;
                    y2--;
                }
            } else if (x1 == x2) {
                if (x1 < len - 1 && x2 < len - 1) {
                    x1++;
                    x2++;
                } else if (x1 > 0 && x2 > 0) {
                    x1--;
                    x2--;
                }
            }
            s[x1][y2] = '*';
            s[x2][y1] = '*';
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    System.out.print(s[i][j]);
                }
                System.out.println();
            }
        }
        sc.close();
    }
}
