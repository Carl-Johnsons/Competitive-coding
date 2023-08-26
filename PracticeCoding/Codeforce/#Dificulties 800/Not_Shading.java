
//https://codeforces.com/problemset/problem/1627/A
import java.util.Scanner;

public class Not_Shading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int hang = sc.nextInt(), cot = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
            String str[] = new String[hang];
            char s[][] = new char[hang][cot];
            boolean has_black = false;
            for (int i = 0; i < hang; i++) {
                str[i] = sc.next();
                if (str[i].contains("B"))
                    has_black = true;
                s[i] = str[i].toCharArray();
            }
            if (has_black) {
                has_black = false;
                if (s[x - 1][y - 1] == 'B')
                    System.out.print(0);
                else {
                    for (int i = 0; i < hang; i++) {
                        if (i != x - 1 && s[i][y - 1] == 'B') {
                            has_black = true;
                            break;
                        }
                    }
                    if (!has_black) {
                        for (int i = 0; i < cot; i++) {
                            if (i != y - 1 && s[x - 1][i] == 'B') {
                                has_black = true;
                                break;
                            }
                        }
                    }
                    if (has_black)
                        System.out.print(1);
                    else
                        System.out.print(2);
                }
            } else
                System.out.print(-1);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
