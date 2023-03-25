
//https://codeforces.com/problemset/problem/978/A
import java.util.Scanner;

public class Remove_Duplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int arr[] = new int[len];
        int count[] = new int[1000];
        int c = len;
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = len - 1; i >= 0; i--) {
            if (count[arr[i] - 1] > 0) {
                arr[i] = 0;
                c--;
            } else
                count[arr[i] - 1]++;
        }
        System.out.println(c);
        for (int i = 0; i < len; i++) {
            if (arr[i] != 0) {
                System.out.print(arr[i]);
                if (i < len - 1)
                    System.out.print(" ");
            }

        }
        sc.close();
    }
}
