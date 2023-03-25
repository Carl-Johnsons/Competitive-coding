import java.util.Scanner;

//https://codeforces.com/problemset/problem/1669/B
public class Triple {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    public static void solve() {
        int len = sc.nextInt();
        int arr[] = new int[len];
        int value_appear_at_least_three_times = -1;
        for (int i = 0; i < len; i++) {
            int value = sc.nextInt();
            arr[value - 1]++;
            if (arr[value - 1] >= 3)
                value_appear_at_least_three_times = value;
        }
        System.out.println(value_appear_at_least_three_times);
    }
}
