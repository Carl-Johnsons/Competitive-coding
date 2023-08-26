
//https://codeforces.com/problemset/problem/1499/A
import java.util.Scanner;

public class Domino_on_Windowsill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            int totalCell = sc.nextInt() * 2;
            int whiteCell = sc.nextInt() + sc.nextInt();
            int white = sc.nextInt(), black = sc.nextInt();
            System.out.print((white * 2 <= whiteCell) && (black * 2 <= (totalCell - whiteCell)) ? "YES" : "NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}