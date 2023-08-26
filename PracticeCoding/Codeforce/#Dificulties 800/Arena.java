
//https://codeforces.com/problemset/problem/1487/A
import java.util.Scanner;

public class Arena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt();
            int arr[] = new int[len], min = 999, near_min = 99999, count_min = 0;
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
            for (int i = 0; i < len; i++) {
                if (near_min > arr[i] && arr[i] != min) {
                    near_min = arr[i];
                }
                if (arr[i] == min)
                    count_min++;
            }
            if (near_min == 99999)
                System.out.print(0);
            else
                System.out.print(len - count_min);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
