
import java.util.Scanner;
//https://codeforces.com/problemset/problem/1538/B

public class Friends_and_Candies {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static int res = 0;

    public static void solve() {
        int len = sc.nextInt();
        int arr[] = new int[len];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        if (sum % len != 0) {
            res = -1;
        } else {
            int mid = sum / len;
            int counting_bigger_than_mid = 0;
            for (int i = 0; i < arr.length; i++) {
                if (mid < arr[i])
                    counting_bigger_than_mid++;
            }
            res = counting_bigger_than_mid;
        }
        System.out.println(res);
    }

}
