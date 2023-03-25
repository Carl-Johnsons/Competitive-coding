
//https://codeforces.com/problemset/problem/1676/C
import java.util.Scanner;

public class Most_Similar_Words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt(), len = sc.nextInt();
            int a = 0, sum[] = new int[2000], min = 99999999;
            String str[] = new String[num];
            for (int i = 0; i < num; i++) {
                str[i] = sc.next();
            }
            for (int k = 0; k < num; k++) {
                for (int i = k + 1; i < num; i++) {
                    for (int j = 0; j < len; j++) {
                        sum[a] += Math.abs(str[k].charAt(j) - str[i].charAt(j));
                    }
                    a++;
                }
            }
            for (int i = 0; i < a; i++) {
                if (min > sum[i])
                    min = sum[i];
            }
            System.out.print(min);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}