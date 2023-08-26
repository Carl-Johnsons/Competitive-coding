
//https://codeforces.com/problemset/problem/707/A
import java.util.Scanner;

public class Brain_Photos {
    public static void main(String[] args) {
        int row, col;
        boolean color = false;
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();
        char str[][] = new char[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                str[i][j] = sc.next().toCharArray()[0];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (str[i][j] != 'W' && str[i][j] != 'B' && str[i][j] != 'G') {
                    color = true;
                }
            }
            if (color)
                break;
        }
        if (color)
            System.out.print("#Color");
        else
            System.out.print("#Black&White");
        sc.close();
    }
}
