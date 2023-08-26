
//https://codeforces.com/problemset/problem/1360/B
import java.util.Scanner;

public class Honest_Coach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int n, min, max;
            n = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = sc.nextInt();
            max = arr[0];
            for (int j = 0; j < n; j++) {
                if (max < arr[j])
                    max = arr[j];
            }
            min = max;
            for (int j = 0; j < n; j++) {
                for (int h = j + 1; h < n; h++) {
                    if (min > Math.abs(arr[j] - arr[h])) {
                        min = Math.abs(arr[j] - arr[h]);
                        if (min == 0)
                            break;
                    }
                }
                if (min == 0)
                    break;
            }
            System.out.print(min);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
