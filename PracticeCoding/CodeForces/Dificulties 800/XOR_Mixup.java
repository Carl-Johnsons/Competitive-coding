
//https://codeforces.com/problemset/problem/1698/A
import java.util.Scanner;

public class XOR_Mixup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt(), result = 0;
            int arr[] = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = 0; j < len; j++) {
                    if (i != j) {
                        sum ^= arr[j];
                    }
                }
                if (sum == arr[i]) {
                    result = sum;
                    break;
                }
            }
            System.out.print(result);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
