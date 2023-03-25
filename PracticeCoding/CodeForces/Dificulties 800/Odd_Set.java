
//https://codeforces.com/problemset/problem/1542/A
import java.util.Scanner;

public class Odd_Set {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int num = sc.nextInt(), count_even = 0, count_odd = 0;
            int arr[] = new int[2 * num];
            for (int j = 0; j < num * 2; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = 0; j < num * 2; j++) {
                if (arr[j] % 2 == 0)
                    count_even++;
                else
                    count_odd++;
            }
            if (count_even != count_odd)
                System.out.print("No");
            else
                System.out.print("Yes");
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
