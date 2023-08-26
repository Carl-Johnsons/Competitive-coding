
//https://codeforces.com/problemset/problem/1669/C
import java.util.Scanner;

public class Odd_Even_Increments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int n = sc.nextInt();
            int arr[] = new int[n], count[] = new int[2];
            boolean odd = false, even = false, okay = true;
            arr[0] = sc.nextInt();
            count[arr[0] % 2]++;
            if (arr[0] % 2 == 0)
                even = true;
            else
                odd = true;
            for (int i = 1; i < n; i++) {
                arr[i] = sc.nextInt();
                count[arr[i] % 2]++;
                if (even && arr[i] % 2 == 0)
                    okay = false;
                else if (odd && arr[i] % 2 == 1)
                    okay = false;
                if (even) {
                    even = false;
                    odd = true;
                } else if (odd) {
                    even = true;
                    odd = false;
                }
            }
            if (okay || count[0] == n || count[1] == n)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
