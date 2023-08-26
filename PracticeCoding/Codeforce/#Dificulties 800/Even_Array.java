//https://codeforces.com/problemset/problem/1367/B

import java.util.Scanner;

public class Even_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int len;
            len = sc.nextInt();
            int arr[] = new int[len], count_odd = 0, count_even = 0;
            for (int j = 0; j < len; j++) {
                arr[j] = sc.nextInt();
                if (j % 2 == 0 && arr[j] % 2 == 1) {
                    count_odd++;
                } else if (j % 2 == 1 && arr[j] % 2 == 0)
                    count_even++;
            }
            if (count_even != count_odd)
                System.out.print(-1);
            else
                System.out.print(count_even);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
