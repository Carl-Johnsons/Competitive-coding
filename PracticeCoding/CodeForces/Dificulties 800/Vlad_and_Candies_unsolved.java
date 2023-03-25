
//https://codeforces.com/problemset/problem/1660/B
import java.util.Scanner;

public class Vlad_and_Candies_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt(), j = 0;
            long arr[] = new long[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextLong();
                if (i > 0) {
                    if (arr[j] > arr[i]) {
                        arr[j] -= arr[i];
                        arr[i] = 0;
                    } else if (arr[j] < arr[i]) {
                        arr[i] -= arr[j];
                        arr[j] = 0;
                        j = i;
                    } else if (arr[j] == arr[i]) {
                        arr[i] = 0;
                        arr[j] = 0;
                        j = i;
                    }
                }
            }
            if (arr[j] <= 1)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
