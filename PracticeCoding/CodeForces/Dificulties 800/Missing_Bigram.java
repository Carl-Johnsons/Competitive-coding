
//https://codeforces.com/problemset/problem/1618/B
import java.util.Scanner;

public class Missing_Bigram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int len = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            StringBuffer sb = new StringBuffer("");
            sb.append(s.substring(0, 2));
            for (int i = 2; i < s.length(); i += 3) {
                String temp = s.substring(i + 1, i + 3);
                if (temp == "\n")
                    break;
                if (sb.charAt(sb.length() - 1) == temp.charAt(0)) {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(temp);
                } else {
                    char t = sb.charAt(sb.length() - 1);
                    if (t == 'a')
                        t = 'b';
                    else
                        t = 'a';
                    sb.append(t);
                    sb.append(temp.charAt(1));
                }
            }
            for (int i = sb.length(); i < len; i++) {
                sb.append(sb.charAt(sb.length() - 1) == 'a' ? 'b' : 'a');
            }
            System.out.print(sb);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
