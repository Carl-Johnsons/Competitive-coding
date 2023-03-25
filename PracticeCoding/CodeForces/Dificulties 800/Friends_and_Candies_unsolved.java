
//https://codeforces.com/problemset/problem/1538/B
import java.util.Scanner;

public class Friends_and_Candies_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt(), max = 0, sum = 0, max_count = 0;
            int arr[] = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
                if (max < arr[i])
                    max = arr[i];
                sum += arr[i];
            }
            if (sum % num != 0)
                System.out.print(-1);
            else {
                for (int i = 0; i < num; i++) {
                    if (arr[i] == max)
                        max_count++;
                }
                if (max_count == num || num == 1)
                    System.out.print(0);
                else
                    System.out.print(max_count);
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
