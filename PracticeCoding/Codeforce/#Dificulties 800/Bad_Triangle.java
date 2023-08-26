
//https://codeforces.com/problemset/problem/1398/A
import java.util.Scanner;

public class Bad_Triangle {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static String res = "";

    public static void solve() {
        int len = sc.nextInt();
        int arr[] = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int first = arr[0], second = arr[1], third = arr[arr.length - 1];
        // Condition for degenerate Triangle with the sorted acsending order array
        if (first + second <= third) {
            res = "1 2 " + (arr.length);
        } else {
            res = "-1";
        }
        System.out.println(res);
    }

}