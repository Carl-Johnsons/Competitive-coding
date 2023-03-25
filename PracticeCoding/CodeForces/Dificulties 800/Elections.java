
//https://codeforces.com/problemset/problem/1593/A
import java.util.Scanner;

public class Elections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            long[] arr = new long[3];
            long max, min, max_count = 0, min_count = 0;
            for (int j = 0; j < 3; j++)
                arr[j] = sc.nextLong();
            if (arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[0])
                System.out.print(1 + " " + 1 + " " + 1);
            else {
                max = arr[0];
                min = arr[0];
                for (int j = 0; j < 3; j++) {
                    if (max < arr[j])
                        max = arr[j];
                    if (min > arr[j])
                        min = arr[j];
                }
                for (int j = 0; j < 3; j++) {
                    if (max == arr[j])
                        max_count++;

                    if (min == arr[j])
                        min_count++;
                }

                for (int j = 0; j < 3; j++) {
                    if (max_count > 1)
                        System.out.print(max - arr[j] + 1);
                    else if (min_count > 1) {
                        if (arr[j] != max)
                            System.out.print(max - arr[j] + 1);
                        else
                            System.out.print(0);
                    } else {
                        if (arr[j] != max)
                            System.out.print(max - arr[j] + 1);
                        else
                            System.out.print(0);
                    }
                    if (j < 2)
                        System.out.print(" ");
                }
            }
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
