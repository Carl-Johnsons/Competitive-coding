
//https://codeforces.com/problemset/problem/1397/A
import java.util.Scanner;

public class Juggling_Letters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int loop = sc.nextInt();
            int[] arr = new int[30];
            boolean okay = true;
            for (int i = 0; i < loop; i++) {
                String str = sc.next();
                char[] s = str.toCharArray();
                for (int j = 0; j < str.length(); j++) {
                    int k = (int) s[j] - (int) 'a';
                    arr[k]++;
                }
            }
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0 && arr[i] % loop != 0) {
                    okay = false;
                    break;
                }
            }
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