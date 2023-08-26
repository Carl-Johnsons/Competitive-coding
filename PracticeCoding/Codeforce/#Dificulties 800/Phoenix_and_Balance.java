
//https://codeforces.com/problemset/problem/1348/A
import java.util.Scanner;

public class Phoenix_and_Balance {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int number, loop, a = 0, sum = 0, sum2 = 0;
            number = sc.nextInt();
            int arr[] = new int[number];
            for (int j = 0; j < number; j++) {
                arr[j] = (int) Math.pow(2, j + 1);
            }
            loop = (number / 2) - 1;
            sum = arr[number - 1];
            while (loop != 0) {
                sum += arr[a];
                a++;
                loop--;
            }
            loop = number / 2;
            while (loop != 0) {
                sum2 += arr[a];
                a++;
                loop--;
            }
            System.out.print(sum - sum2);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
