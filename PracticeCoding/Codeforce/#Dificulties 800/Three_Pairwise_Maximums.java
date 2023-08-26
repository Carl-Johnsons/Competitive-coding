
//https://codeforces.com/problemset/problem/1385/A
import java.util.Scanner;

public class Three_Pairwise_Maximums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testcase = sc.nextLong();
        for (long i = 0; i < testcase; i++) {
            long arr[] = new long[3], min, max, count_min = 0;
            for (int j = 0; j < 3; j++)
                arr[j] = sc.nextLong();
            max = arr[0];
            min = arr[0];
            for (int j = 0; j < 3; j++) {
                if (max < arr[j])
                    max = arr[j];
                if (min > arr[j])
                    min = arr[j];
            }
            for (int j = 0; j < 3; j++) {
                if (arr[j] == min)
                    count_min++;
            }
            if ((arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2]) || count_min == 2)
                System.out.print("NO");
            else {
                System.out.println("YES");
                System.out.print(min + " " + min + " " + max + " ");
            }
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
