
//https://codeforces.com/problemset/problem/731/A
import java.util.Scanner;

public class Night_at_the_Museum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] s = str.toCharArray();
        int sum, initial_pos = 0, total = 0;
        for (int j = 0; j < str.length(); j++) {
            sum = 0;
            for (int i = initial_pos; i <= 26;) {
                if ((char) (i + 97) == s[j]) {
                    if (sum >= 13)
                        sum = Math.abs(sum - 26);
                    break;
                }
                i = ((i + 1) % 26);
                sum++;
            }
            total += sum;
            initial_pos = s[j] - 97;
        }
        System.out.print(total);
        sc.close();
    }
}
