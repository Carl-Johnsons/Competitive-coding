
//https://codeforces.com/problemset/problem/1385/B
import java.util.Scanner;

public class Restore_the_Permutation_by_Merger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int n = sc.nextInt();
            int arr[] = new int[2 * n], already_have[] = new int[n * 2], a = 0;
            for (int j = 0; j < n * 2; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = 0; j < n * 2; j++) {
                if (arr[j] <= n) {
                    if (a == n)
                        break;
                    already_have[a] = arr[j];
                    for (int h = 0; h < a; h++) {
                        if (already_have[a] == already_have[h]) {
                            a--;
                        }
                    }
                    a++;
                }
            }
            for (int j = 0; j < a; j++) {
                System.out.print(already_have[j]);
                if (j < a - 1)
                    System.out.print(" ");
            }
            if (i < testcase - 1)
                System.out.print("\n");

        }
        sc.close();
    }
}
