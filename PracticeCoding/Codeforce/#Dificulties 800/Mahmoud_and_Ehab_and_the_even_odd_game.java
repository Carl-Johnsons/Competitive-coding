
//https://codeforces.com/problemset/problem/959/A
import java.util.Scanner;

public class Mahmoud_and_Ehab_and_the_even_odd_game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0)
            System.out.print("Mahmoud");
        else
            System.out.print("Ehab");
        sc.close();
    }
}
