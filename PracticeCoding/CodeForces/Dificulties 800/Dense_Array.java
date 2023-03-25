
//https://codeforces.com/problemset/problem/1490/A
import java.util.Scanner;

public class Dense_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt(), insert = 0, loop = 0, ma, mi;
            int arr[] = new int[num];
            for (int i = 0; i < num; i++)
                arr[i] = sc.nextInt();
            for (int i = 0; i < num - 1; i++) {
                loop = 0;
                ma = max(arr[i], arr[i + 1]);
                mi = min(arr[i], arr[i + 1]);
                if (ma > 2 * mi) {
                    while (true) {
                        mi *= 2;
                        loop++;
                        if (ma <= 2 * mi)
                            break;
                    }
                    insert += loop;
                }
            }
            System.out.print(insert);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }

    public static int min(int x, int y) {
        int m = x;
        if (m > y)
            m = y;
        return m;
    }

    public static int max(int x, int y) {
        int m = x;
        if (m < y)
            m = y;
        return m;
    }
}
