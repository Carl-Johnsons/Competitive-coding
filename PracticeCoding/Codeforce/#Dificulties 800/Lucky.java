
//https://codeforces.com/problemset/problem/1676/A
import java.util.Scanner;

public class Lucky {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int num = sc.nextInt(), j = 0, digit = 100000;
            int arr[] = new int[6];
            while (true) {
                arr[j] = num / digit;
                num %= digit;
                digit /= 10;
                if (j == 5)
                    break;
                j++;
            }
            if (arr[0] + arr[1] + arr[2] == arr[3] + arr[4] + arr[5])
                System.out.print("YES");
            else
                System.out.print("NO");
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
