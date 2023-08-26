
//https://codeforces.com/problemset/problem/32/B
import java.util.Scanner;

public class Borze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char khong = '.';
        String mot = "-.";
        String hai = "--";
        String sub = "";
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1)
                sub = str.substring(i, i + 2);
            if (i < str.length() - 1) {
                if (sub.compareTo(mot) == 0) {
                    System.out.print(1);
                    i++;
                } else if (sub.compareTo(hai) == 0) {
                    System.out.print(2);
                    i++;
                } else if (str.charAt(i) == khong) {
                    System.out.print(0);
                }
            } else if (str.charAt(i) == khong) {
                System.out.print(0);
            }
        }
        sc.close();
    }

}
