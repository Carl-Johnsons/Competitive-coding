
//https://codeforces.com/problemset/problem/1703/C
import java.util.Scanner;

public class Cypher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt();
            int arr[] = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < num; i++) {
                int len = sc.nextInt();
                String str = sc.next();
                char[] s = str.toCharArray();
                for (int j = 0; j < len; j++) {
                    if (s[j] == 'D')
                        arr[i]++;
                    else if (s[j] == 'U')
                        arr[i]--;
                    if (arr[i] == 10)
                        arr[i] = 0;
                    else if (arr[i] == -1)
                        arr[i] = 9;
                }
            }
            for (int i = 0; i < num; i++) {
                System.out.print(arr[i]);
                if (i < num - 1)
                    System.out.print(" ");
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
