
//https://codeforces.com/problemset/problem/1692/C
import java.util.Scanner;

public class Where_the_Bishop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int hang = 0, cot = 0;
            String str[] = new String[8];
            for (int j = 0; j < 8; j++) {
                str[j] = sc.next();
            }
            char[][] s = new char[8][8];
            for (int j = 0; j < 8; j++) {
                s[j] = str[j].toCharArray();
            }
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 7; j++) {
                    if (s[i][j] == '#' && s[i + 1][j + 1] == '#' && s[i + 1][j - 1] == '#') {
                        hang = i;
                        cot = j;
                        break;
                    }
                }
            }
            System.out.print((hang + 1) + " " + (cot + 1));
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
