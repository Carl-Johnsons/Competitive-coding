
//https://codeforces.com/problemset/problem/1462/A
import java.util.Scanner;

public class Favorite_Sequence {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int num = sc.nextInt();
            int arr[] = new int[num + 1];
            for (int j = 1; j <= num; j += 2) {
                arr[j] = sc.nextInt();
            }
            for (int j = num % 2 == 0 ? num : num - 1; j >= 2; j -= 2) {
                arr[j] = sc.nextInt();
            }
            for (int j = 1; j <= num; j++) {
                System.out.print(arr[j]);
                if (j <= num - 1)
                    System.out.print(" ");
            }
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }

}
