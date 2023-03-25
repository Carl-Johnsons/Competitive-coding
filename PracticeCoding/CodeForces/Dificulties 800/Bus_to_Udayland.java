
//https://codeforces.com/problemset/problem/711/A
import java.util.Scanner;

public class Bus_to_Udayland {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        String str[] = new String[row];
        boolean okay = false;
        for (int i = 0; i < row; i++) {
            str[i] = sc.next();
        }
        char s[][] = new char[row][100];
        for (int i = 0; i < row; i++) {
            s[i] = str[i].toCharArray();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 4; j += 3) {
                if (s[i][j] == 'O' && s[i][j + 1] == 'O') {
                    okay = true;
                    s[i][j] = '+';
                    s[i][j + 1] = '+';
                    break;
                }
            }
            if (okay)
                break;
        }
        if (okay) {
            System.out.println("YES");
            for (int i = 0; i < row; i++) {
                String a = new String(s[i]);
                System.out.print(a);
                if (i < row - 1)
                    System.out.println();
            }
        } else
            System.out.print("NO");
        sc.close();
    }
}
