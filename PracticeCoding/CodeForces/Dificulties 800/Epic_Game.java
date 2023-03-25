
//https://codeforces.com/problemset/problem/119/A
import java.util.Scanner;

public class Epic_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), stone = sc.nextInt(), turn;
        boolean Simon = true;
        while (true) {
            if (Simon) {
                turn = a;
                Simon = false;
            } else {
                turn = b;
                Simon = true;
            }
            stone -= (gcd(turn, stone));
            if (stone < 0)
                break;
        }
        if (!Simon)
            System.out.print(1);
        else
            System.out.print(0);
        sc.close();
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else
            return gcd(y, x % y);
    }
}