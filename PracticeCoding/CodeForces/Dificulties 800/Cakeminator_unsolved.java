
//https://codeforces.com/problemset/problem/330/A
import java.util.Scanner;

public class Cakeminator_unsolved {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hang = sc.nextInt(), cot = sc.nextInt(), a = 0;
        String str[] = new String[hang];
        for (int i = 0; i < hang; i++) {
            str[i] = sc.next();
            if (str[i].contains("S")) {
                a++;
            }
        }
        int row = (hang - a) * cot;
        int col = (cot  - a) * a;
        System.out.print(row + col);
        sc.close();
    }
}
