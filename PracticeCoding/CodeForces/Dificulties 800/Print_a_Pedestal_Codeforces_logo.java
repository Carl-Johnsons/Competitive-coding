
//https://codeforces.com/problemset/problem/1690/A
import java.util.Scanner;

public class Print_a_Pedestal_Codeforces_logo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt(), max, min, mid;
            int arr[] = new int[3];
            arr[0] = num / 3;
            arr[1] = arr[0] - 1;
            arr[2] = num - (arr[0] + arr[1]);
            max = min = mid = arr[0];
            for (int i = 0; i < 3; i++) {
                if (max < arr[i])
                    max = arr[i];
                if (min > arr[i])
                    min = arr[i];
            }
            for (int i = 0; i < 3; i++) {
                if (arr[i] != max && arr[i] != min) {
                    mid = arr[i];
                }
            }
            while (max - mid > 2) {
                mid++;
                max--;
            }
            System.out.print(mid + " " + max + " " + min);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
