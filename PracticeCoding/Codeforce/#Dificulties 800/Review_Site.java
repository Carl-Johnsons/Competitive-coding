
//https://codeforces.com/problemset/problem/1511/A
import java.util.Scanner;

public class Review_Site {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int len = sc.nextInt();
            int arr[] = new int[len], count = 0;
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] == 1 || arr[i] == 3)
                    count++;
            }
            System.out.print(count);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
