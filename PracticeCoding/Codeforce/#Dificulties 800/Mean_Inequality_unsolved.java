
//https://codeforces.com/problemset/problem/1526/A
import java.util.Scanner;

public class Mean_Inequality_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int len = sc.nextInt();
            long arr[] = new long[2 * len];
            for (int i = 0; i < len * 2; i++)
                arr[i] = sc.nextInt();
            if (len > 1) {
                for (int j = 0; j < 2; j++) {
                    for (int i = 0; i < len * 2; i++) {
                        int back = i - 1;
                        int front = i + 1;
                        if (back < 0)
                            back = len * 2 - 1;
                        if (front == len * 2)
                            front = 0;
                        if ((arr[back] + arr[front]) / 2 == arr[i]) {
                            long temp = arr[front];
                            arr[front] = arr[i];
                            arr[i] = temp;
                            temp = arr[i];
                            arr[i] = arr[back];
                            arr[back] = temp;
                        }
                    }
                }
            } else {
                long temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
            for (int i = 0; i < len * 2; i++) {
                System.out.print(arr[i]);
                if (i < len * 2 - 1)
                    System.out.print(" ");
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
