
//https://codeforces.com/problemset/problem/1554/A
import java.util.Scanner;

public class Cherry {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static long res = 0;

    public static void solve() {
        res = 0;
        // The idea is findding the max first, then multiply the left side of the max or
        // the right side

        int len = sc.nextInt();
        long arr[] = new long[len];
        int before = -1;
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextLong();
            for (int j = before - 1; j <= before + 1; j += 2) {
                if (j >= 0 && j < len && before >= 0 && before < len)
                    if (res < arr[j] * arr[before]) {
                        res = arr[j] * arr[before];
                    }
            }

            before++;
        }

        System.out.println(res);
    }

}