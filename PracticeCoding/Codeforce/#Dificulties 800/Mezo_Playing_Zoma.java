
//https://codeforces.com/problemset/problem/1285/A
import java.util.Scanner;

public class Mezo_Playing_Zoma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(), left = 0, right = 0;
        String str = sc.next();
        char s[] = str.toCharArray();
        for (int i = 0; i < len; i++) {
            if (s[i] == 'L')
                left--;
            else
                right++;
        }
        System.out.print(right - left + 1);
        sc.close();
    }
}
