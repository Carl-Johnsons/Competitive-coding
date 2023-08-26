import java.util.Scanner;

//https://codeforces.com/problemset/problem/1760/A
public class Medium_Number {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = sc.nextInt();
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    public static void solve() {
        int max = 0, mid = -1, min = Integer.MAX_VALUE;
        int arr[] = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (arr[i] != min && arr[i] != max) {
                mid = arr[i];
            }
        }

        System.out.println(mid);
    }
}
