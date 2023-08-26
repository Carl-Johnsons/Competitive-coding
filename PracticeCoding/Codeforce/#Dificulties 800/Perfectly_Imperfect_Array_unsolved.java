
//https://codeforces.com/problemset/problem/1514/A
import java.util.Scanner;

public class Perfectly_Imperfect_Array_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int len = sc.nextInt();
            int arr[] = new int[len];
            long product = 1, temp = 1;
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
                product *= arr[i];
                temp = (long) (Math.pow((long) Math.sqrt((product)), 2));
                if (product == temp) {
                    product = 1;
                    temp = 1;
                }
            }
            if (product == temp) {
                System.out.print("NO");
            } else
                System.out.print("YES");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
