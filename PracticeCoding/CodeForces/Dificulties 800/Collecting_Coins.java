
//https://codeforces.com/problemset/problem/1294/A
import java.util.Scanner;

public class Collecting_Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int arr[] = new int[3], Polycarp, max;
            for (int j = 0; j < 3; j++)
                arr[j] = sc.nextInt();
            Polycarp = sc.nextInt();
            max = arr[0];
            for (int j = 0; j < 3; j++) {
                if (max < arr[j])
                    max = arr[j];
            }
            for (int j = 0; j < 3; j++) {
                if (Polycarp <= 0)
                    break;
                if (arr[j] != max) {
                    if (Polycarp - (max - arr[j]) < 0) {
                        arr[j] += Polycarp;
                        Polycarp = 0;
                        break;
                    }
                    Polycarp -= (max - arr[j]);
                    arr[j] += (max - arr[j]);
                }
            }
            if (Polycarp % 3 == 0 && arr[0] == arr[1] && arr[0] == arr[2])
                System.out.print("YES");
            else
                System.out.print("NO");
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
