
//https://codeforces.com/problemset/problem/1569/A
import java.util.Scanner;

public class Balanced_Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt(), x = 0, y = 0;
            String str = sc.next();
            for (int i = 0; i < len - 1; i++) {
                int count[] = new int[2];
                char temp[] = str.substring(i, i + 2).toCharArray();
                for (int j = 0; j < 2; j++) {
                    count[temp[j] - (int) 'a']++;
                }
                if (count[0] == count[1]) {
                    x = i + 1;
                    y = i + 2;
                    break;
                }
            }
            if (x == 0 && y == 0)
                System.out.print(-1 + " " + (-1));
            else
                System.out.format("%d %d", x, y);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
