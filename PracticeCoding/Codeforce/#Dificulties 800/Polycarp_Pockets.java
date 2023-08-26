
//https://codeforces.com/problemset/problem/1003/A
import java.util.Scanner;

public class Polycarp_Pockets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(), pockets = 0;
        int arr[] = new int[len], count[] = new int[100];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
            count[arr[i] - 1]++;
        }
        for (int i = 0; i < 100; i++) {
            if (pockets < count[i])
                pockets = count[i];
        }
        System.out.print(pockets);
        sc.close();
    }
}