
//https://codeforces.com/problemset/problem/1462/B
import java.util.Scanner;

public class Last_Year_Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt(), j = 0;
            String s = sc.next(), a = "2020";
            char[] str = s.toCharArray(), nam_moi = a.toCharArray();
            boolean gay_khuc = false, okay = false;
            for (int i = 0; i < len; i++) {
                if (str[i] == nam_moi[j] && !gay_khuc) {
                    j++;
                    if (j == 4)
                        break;
                } else if (str[i] != nam_moi[j]) {
                    gay_khuc = true;
                    break;
                }
            }
            if (gay_khuc) {
                String temp1 = a.substring(j, 4);
                String temp2 = s.substring(s.length() - (4 - j), s.length());
                if (temp1.compareTo(temp2) == 0) {
                    okay = true;
                }
            }
            if (okay || !gay_khuc)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
