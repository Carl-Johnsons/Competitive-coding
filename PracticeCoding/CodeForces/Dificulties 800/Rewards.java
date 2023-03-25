
//https://codeforces.com/problemset/problem/448/A
import java.util.Scanner;

public class Rewards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cups = 0, medals = 0;
        for (int i = 1; i <= 3; i++) {
            cups += sc.nextInt();
        }
        for (int i = 1; i <= 3; i++) {
            medals += sc.nextInt();
        }
        int shelves = sc.nextInt();
        if (medals % 10 != 0)
            shelves--;
        if (cups % 5 != 0)
            shelves--;
        if (medals != 0)
            shelves -= (medals / 10);
        if (cups != 0)
            shelves -= (cups / 5);
        if (shelves >= 0)
            System.out.print("YES");
        else
            System.out.print("NO");
        sc.close();
    }
}
