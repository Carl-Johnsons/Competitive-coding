
//https://codeforces.com/problemset/problem/1560/C
import java.util.Scanner;

public class Infinity_Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long num = sc.nextLong(), hang = 0, cot = 0, max_chan = 0, sum_chan = 0;
            hang = (long) Math.sqrt((double) num);
            // Di xuong la bay nhieu hang thi binh phuong len
            while (power(hang, 2) < num) {
                hang++;
            }
            cot = hang;
            // Duong cheo la sum chan tang dan
            max_chan = 2 + (hang - 2) * 2;
            sum_chan = 1 + ((max_chan + 2) * max_chan / 2) / 2;
            if (num > sum_chan) {
                cot -= (num - sum_chan);
            } else if (num < sum_chan) {
                hang -= (sum_chan - num);
            }
            System.out.print(hang + " " + cot);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }

    public static long power(long a, long b) {
        if (b == 0)
            return 1;
        else
            return power(a, b - 1) * a;
    }
}
