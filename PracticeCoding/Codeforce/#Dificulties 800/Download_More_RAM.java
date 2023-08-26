
//https://codeforces.com/problemset/problem/1629/A
import java.util.Scanner;

public class Download_More_RAM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int n = sc.nextInt(), k = sc.nextInt();
            int[] arrA = new int[n], arrB = new int[n];
            for (int i = 0; i < n; i++)
                arrA[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                arrB[i] = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (arrA[i] != 0 && k >= arrA[i]) {
                    arrA[i] = 0;
                    k += arrB[i];
                    i = -1;
                }
            }
            System.out.print(k);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
