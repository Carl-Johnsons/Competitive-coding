
//https://codeforces.com/problemset/problem/1709/A
import java.util.Scanner;

public class Three_Doors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int key = sc.nextInt();
            int arr[] = new int[4], turn = 0;
            boolean okay = true;
            for (int i = 1; i <= 3; i++) {
                arr[i] = sc.nextInt();
            }
            while (turn < 3) {
                key = arr[key];
                turn++;
                if (key == 0 && turn != 3) {
                    okay = false;
                    break;
                }
            }
            if (okay)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
