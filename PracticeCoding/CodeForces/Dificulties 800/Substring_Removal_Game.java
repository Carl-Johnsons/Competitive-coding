
//https://codeforces.com/problemset/problem/1398/B
import java.util.Scanner;

public class Substring_Removal_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            String str = sc.next();
            char s[] = str.toCharArray();
            int j = 0, count[] = new int[str.length()], score = 0;
            for (int i = 0; i < str.length(); i++) {
                if (s[i] == '1') {
                    while (s[i] != '0') {
                        count[j]++;
                        if (i == str.length() - 1)
                            break;
                        i++;
                    }
                    j++;
                }
            }
            for (int i = 0; i < j; i++) {
                for (int k = i + 1; k < j; k++) {
                    if (count[i] < count[k]) {
                        int temp = count[i];
                        count[i] = count[k];
                        count[k] = temp;
                    }
                }
            }
            for (int i = 0; i < j; i++) {
                if (i % 2 == 0)
                    score += count[i];
            }
            System.out.print(score);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}