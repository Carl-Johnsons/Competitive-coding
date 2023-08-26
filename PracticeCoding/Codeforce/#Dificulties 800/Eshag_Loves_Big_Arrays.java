
//https://codeforces.com/problemset/problem/1529/A
import java.util.Scanner;

public class Eshag_Loves_Big_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt(), count = 0;
            int arr[] = new int[len], min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
                if (min > arr[i])
                    min = arr[i];
            }
            for (int i = 0; i < len; i++) {
                if (arr[i] > min)
                    count++;
            }
            System.out.print(count);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
