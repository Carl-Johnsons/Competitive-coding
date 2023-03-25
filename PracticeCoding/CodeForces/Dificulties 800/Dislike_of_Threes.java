
//https://codeforces.com/problemset/problem/1560/A
import java.util.Scanner;

public class Dislike_of_Threes {
    public static void main(String[] args) {
        int testcase = 0, so = 0;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        int arr[] = new int[testcase];
        for (int i = 0; i < testcase; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < testcase; i++) {
            so = 0;
            for (int j = 1; j <= arr[i]; j++) {
                do {
                    so++;
                } while (((so % 3 == 0 || so % 10 == 3) && so != 0));
            }
            System.out.print(so);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
