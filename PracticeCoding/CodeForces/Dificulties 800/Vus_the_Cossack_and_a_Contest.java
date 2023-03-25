
//https://codeforces.com/problemset/problem/1186/A
import java.util.Scanner;

public class Vus_the_Cossack_and_a_Contest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        if (b < a || c < a)
            System.out.print("NO");
        else
            System.out.print("YES");
        sc.close();
    }
}
