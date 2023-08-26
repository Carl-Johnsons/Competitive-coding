
//https://codeforces.com/problemset/problem/1433/B
import java.util.Scanner;

public class Yet_Another_Bookshelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int count = 0, start = 0, end = 0, len = sc.nextInt();
            boolean start_e = false;
            int arr[] = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] == 1 && !start_e) {
                    start = i;
                    start_e = true;
                }
            }
            for (int i = len - 1; i >= 0; i--) {
                if (arr[i] == 1) {
                    end = i;
                    break;
                }
            }
            for (int i = start; i <= end; i++) {
                if (arr[i] == 0) {
                    count++;
                }
            }
            System.out.print(count);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
