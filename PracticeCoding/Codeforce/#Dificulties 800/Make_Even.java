
//https://codeforces.com/problemset/page/2?order=BY_RATING_ASC
import java.util.Scanner;

public class Make_Even {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long num = sc.nextLong(), move = 0, arr[] = new long[100], chuso;
            int j = 0;
            chuso = digit(num) - 1;
            boolean okay = false;
            if (num % 2 == 1) {
                while (num != 0) {
                    arr[j] = num / pow(10, chuso);
                    num %= pow(10, chuso);
                    chuso--;
                    j++;
                }
                if (arr[0] % 2 == 0) {
                    okay = true;
                    move = 1;
                } else {
                    for (int i = 1; i <j; i++) {
                        if (arr[i] % 2 == 0) {
                            okay = true;
                            move = 2;
                            break;
                        }
                    }
                }
            } else if (num % 2 == 0)
                okay = true;
            if (okay)
                System.out.print(move);
            else
                System.out.print(-1);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }

    public static long digit(long x) {
        long count = 0;
        while (x != 0) {
            x /= 10;
            count++;
        }
        return count;
    }

    public static long pow(long x, long y) {
        if (y == 0)
            return 1;
        else
            return pow(x, y - 1) * x;
    }
}
