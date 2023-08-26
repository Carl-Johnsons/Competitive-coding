
//https://codeforces.com/problemset/problem/1492/A
import java.util.Scanner;

public class Three_swimmers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            long min = Long.MAX_VALUE;
            long p = sc.nextLong(), arr[] = new long[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextLong();
                long temp = arr[i];
                arr[i] = (p > temp) ? (((p / temp) + (long) ((p % temp == 0) ? 0 : 1)) * temp) : temp;
                if (arr[i] < min)
                    min = arr[i];
            }
            System.out.print(min-p);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
