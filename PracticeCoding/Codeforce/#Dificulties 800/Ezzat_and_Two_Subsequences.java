
//https://codeforces.com/problemset/problem/1557/A
import java.util.Scanner;

public class Ezzat_and_Two_Subsequences {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static double res = 0.0;

    public static void solve() {
        int len = sc.nextInt();
        int arr[] = new int[len], max = Integer.MIN_VALUE;
        double sum = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
            sum += arr[i];
        }
        // average of the left part and the right part has only max
        sum = (sum - max) / (double) (len - 1);
        res = sum + max;
        System.out.printf("%.9f\n", res);
    }

}