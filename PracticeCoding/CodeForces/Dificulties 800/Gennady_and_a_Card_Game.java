
//https://codeforces.com/problemset/problem/1097/A
import java.util.Scanner;

public class Gennady_and_a_Card_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean oke = false;
        char[] a = new char[7], b = new char[7];
        for (int i = 0; i < 6; i++) {
            String temp = sc.next();
            a[i] = temp.toCharArray()[0];
            b[i] = temp.toCharArray()[1];
        }
        for (int i = 1; i < 6; i++) {
            if (a[0] == a[i] || b[0] == b[i]) {
                oke = true;
                break;
            }
        }
        if (oke)
            System.out.print("YES");
        else
            System.out.print("NO");
        sc.close();
    }
}
