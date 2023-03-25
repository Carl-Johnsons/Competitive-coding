
//https://codeforces.com/problemset/problem/1535/A
import java.util.Scanner;

public class Fair_Playoff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int arr[] = new int[4], max1, max2, min, min1, min2, max;
            for (int j = 0; j < 4; j++) {
                arr[j] = sc.nextInt();
            }
            max1 = arr[0];
            min1 = arr[1];
            max2 = arr[2];
            min2 = arr[3];
            if (max1 < arr[1]) {
                min1 = arr[0];
                max1 = arr[1];
            }
            if (max2 < arr[3]) {
                min2 = arr[2];
                max2 = arr[3];
            }
            min = max1;
            if (min > max2)
                min = max2;
            max = min1;
            if (max < min2)
                max = min2;
            if (min < max) {
                System.out.print("NO");
            } else
                System.out.print("YES");
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
