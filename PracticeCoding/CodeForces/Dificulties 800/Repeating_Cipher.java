
//https://codeforces.com/problemset/problem/1095/A
import java.util.Scanner;

public class Repeating_Cipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(), increment = 1, j = 0;
        String str = sc.next();
        char s[] = str.toCharArray(), result[] = new char[56];
        for (int i = 0; i < len;) {
            result[j] = s[i];
            i += increment;
            j++;
            increment++;
        }
        for (int i = 0; i < j; i++)
            System.out.print(result[i]);
        sc.close();
    }
}
