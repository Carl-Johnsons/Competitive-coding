
//https://codeforces.com/problemset/problem/1196/A
import java.util.Scanner;

public class Three_Piles_of_Candies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            Long arr[] = new Long[3], max = 0L, min, max_loc = 0L, min_loc = 0L, mid = 0L;
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextLong();
                if (max < arr[i]) {
                    max = arr[i];
                    max_loc = (long) i;
                }
            }
            min = arr[0];
            for (int i = 0; i < 3; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    min_loc = (long) i;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (i != max_loc && i != min_loc)
                    mid = arr[i];
            }
            mid += ((max - (mid - min)) / 2);
            System.out.print(mid);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
