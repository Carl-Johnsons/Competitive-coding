
//https://codeforces.com/problemset/problem/1538/A
import java.util.Scanner;

public class Stone_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int len = sc.nextInt(), min = 999, max = 0, min_loc = 0, max_loc = 0;
            for (int i = 0; i < len; i++) {
                int k = sc.nextInt();
                if (min > k) {
                    min = k;
                    min_loc = i + 1;
                }
                if (max < k) {
                    max = k;
                    max_loc = i + 1;
                }
            }
            if (min_loc > max_loc) {
                int temp = min_loc;
                min_loc = max_loc;
                max_loc = temp;
            }
            min = 0;
            int min_dis = min_loc, max_dis = (len - max_loc) + 1;
            int left = len - min_loc + 1;
            int right = max_loc;
            int sum = min_dis + max_dis;
            min = left;
            if (min > right)
                min = right;
            if (min > sum)
                min = sum;
            System.out.print(min);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}