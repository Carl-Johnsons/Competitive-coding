import java.util.Scanner;

//https://codeforces.com/problemset/problem/1742/A
public class Sum {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = sc.nextInt();
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    public static void solve() {
        int arr[] = new int[3];
        int maxIndex = 0, sum = 0;
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
            if (arr[maxIndex] < arr[i])
                maxIndex = i;
            sum += arr[i];
        }
        sum = arr[maxIndex];
        for (int i = 0; i < 3; i++) {
            if (i != maxIndex) {
                sum -= arr[i];
            }
        }
        String res = "";
        if (sum == 0) {
            res = "YES";
        } else {
            res = "NO";
        }
        System.out.println(res);
    }
}
