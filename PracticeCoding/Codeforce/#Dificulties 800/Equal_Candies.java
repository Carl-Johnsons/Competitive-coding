
//https://codeforces.com/problemset/problem/1676/B
import java.util.Scanner;

public class Equal_Candies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int min, num = sc.nextInt(), total = 0;
            int arr[] = new int[num];
            for (int j = 0; j < num; j++) {
                arr[j] = sc.nextInt();
            }
            min = arr[0];
            for (int j = 0; j < num; j++) {
                if (min > arr[j])
                    min = arr[j];
            }
            for (int j = 0; j < num; j++) {
                if (arr[j] != min) {
                    total += (arr[j] - min);
                }
            }
            System.out.print(total);
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
