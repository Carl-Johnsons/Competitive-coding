
//https://codeforces.com/problemset/problem/1547/B
import java.util.Scanner;

public class Alphabetical_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            String str = sc.next();
            char s[] = str.toCharArray();
            int a_position = 0, left_pos = 0, right_pos = 0;
            boolean okay = true, a_found = false, left_found = false, right_found = false;
            for (int i = 0; i < str.length(); i++) {
                if (s[i] == 'a') {
                    a_position = i;
                    a_found = true;
                    break;
                }
            }
            if (a_found) {
                if (a_position > 0) {
                    left_pos = a_position - 1;
                    left_found = true;
                }
                if (a_position < str.length() - 1) {
                    right_pos = a_position + 1;
                    right_found = true;
                }
                if (str.length() > 1) {
                    for (char i = 'b'; i <= (str.length() - 1) + 'a'; i++) {
                        if (s[left_pos] == i && left_found) {
                            if (left_pos > 0)
                                left_pos--;
                        } else if (s[right_pos] == i && right_found) {
                            if (right_pos < str.length() - 1)
                                right_pos++;
                        } else {
                            okay = false;
                            break;
                        }
                    }
                } else {
                    if (s[0] != 'a')
                        okay = false;
                }
            } else
                okay = false;
            if (okay)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
