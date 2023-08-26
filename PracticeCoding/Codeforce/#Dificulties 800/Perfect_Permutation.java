
//https://codeforces.com/problemset/problem/233/A
import java.util.Scanner;

public class Perfect_Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int arr[] = new int[len], perm[] = new int[len], j = 0;
        if (len % 2 == 0) {
            for (int i = 0; i < len; i++)
                arr[i] = i + 1;
            for (int i = 1; j < len;) {
                perm[j] = arr[i];
                if (i % 2 == 1)
                    i--;
                else
                    i += 3;
                j++;
            }
            for (int i = 0; i < len; i++) {
                System.out.print(perm[i]);
                if (i < len - 1)
                    System.out.print(" ");
            }
        } else
            System.out.print(-1);
        sc.close();
    }
}
