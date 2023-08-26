
//https://codeforces.com/problemset/problem/1296/A
import java.util.Scanner;

public class Array_with_Odd_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int num = sc.nextInt(), count_odd = 0, count_even = 0;
            int arr[] = new int[num];
            for (int j = 0; j < num; j++)
                arr[j] = sc.nextInt();
            for (int j = 0; j < num; j++)
                if (arr[j] % 2 == 1)
                    count_odd++;
                else {
                    count_even++;
                }
            if (count_odd % 2 == 1 || (count_even >= 1 && count_odd > 0))
                System.out.print("YES");
            else
                System.out.print("NO");
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
