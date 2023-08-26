
//https://codeforces.com/problemset/problem/1547/A
import java.util.Scanner;

public class Shortest_Path_with_Obstacle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            boolean block = false;
            int moves = 0, a = 0;
            int arr[][] = new int[3][2];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < 2; i++) {
                if (arr[0][i] == arr[2][i] && arr[1][i] == arr[2][i]) {
                    if (i == 0)
                        a = i + 1;
                    else
                        a = i - 1;
                    if ((arr[2][a] <= arr[0][a] && arr[2][a] >= arr[1][a])
                            || (arr[2][a] >= arr[0][a] && arr[2][a] <= arr[1][a]))
                        block = true;
                    break;
                }
            }
            moves = Math.abs(arr[0][0] - arr[1][0]) + Math.abs(arr[0][1] - arr[1][1]);
            if (block)
                moves += 2;
            System.out.print(moves);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}