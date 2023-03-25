
//https://codeforces.com/problemset/problem/1220/A
import java.util.Scanner;

public class Cards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String str = sc.next();
        char[] s = str.toCharArray();
        int count[] = new int[30], min_z = 0, min_o = 0;
        for (int i = 0; i < len; i++) {
            int k = s[i] - (int) 'a';
            count[k]++;
        }
        // 4 e, 13 n, 14 o, 17 r, 25 z
        min_o = min(min(count[14], count[13]), count[4]);
        for (int i = 0; i < min_o; i++) {
            System.out.print(1);
            if (i < min_o - 1)
                System.out.print(" ");
        }
        count[14] -= min_o;
        count[4] -= min_o;
        min_z = min(min(count[25], count[4]), min(count[17], count[14]));
        if (min_o != 0)
            System.out.print(" ");
        for (int i = 0; i < min_z; i++) {
            System.out.print(0);
            if (i < min_z - 1)
                System.out.print(" ");
        }
        sc.close();
    }

    public static int min(int x, int y) {
        int m = x;
        if (m > y)
            m = y;
        return m;
    }
}
