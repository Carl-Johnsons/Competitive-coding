
//https://codeforces.com/problemset/problem/1399/A
import java.util.Scanner;

public class Remove_Smallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt(), min_location = 0;
            int arr[] = new int[len];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < arr.length - 1; i++) {
                int min = 999;
                for (int j = 0; j < arr.length; j++) {
                    if (min > arr[j] && arr[j] != 0) {
                        min = arr[j];
                        min_location = j;
                    }
                }
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] == min && j != min_location) {
                        arr[j] = 0;
                        len--;
                    }
                    if (arr[j] == min + 1 && arr[min_location] != 0) {
                        arr[min_location] = 0;
                        len--;
                    }
                }
            }
            if (len == 1)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
