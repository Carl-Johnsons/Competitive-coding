
//https://codeforces.com/problemset/problem/1454/B]
import java.util.Scanner;

public class Unique_Bid_Auction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt(), result = -1;
            int arr[] = new int[len + 1], count[] = new int[len + 1];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
                count[arr[i]]++;
            }
            for (int i = 1; i <= len; i++) {
                if (count[i] == 1) {
                    result = i;
                    break;
                }
            }
            if (result != -1) {
                for (int i = 0; i < len; i++) {
                    if (arr[i] == result) {
                        result = i + 1;
                        break;
                    }
                }
            }
            System.out.print(result);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();

    }
}
