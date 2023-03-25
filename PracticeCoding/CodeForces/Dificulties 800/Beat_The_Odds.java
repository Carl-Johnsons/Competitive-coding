
//https://codeforces.com/problemset/problem/1691/A
import java.util.Scanner;

public class Beat_The_Odds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt();
            long arr[] = new long[len], count[] = new long[2], min = 0;
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextLong();
                count[(int) (arr[i] % 2)]++;
            }
            min = count[0];
            if (min > count[1])
                min = count[1];
            System.out.print(min);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
