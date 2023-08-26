
//https://codeforces.com/problemset/problem/540/A
import java.util.Scanner;

public class Combination_Lock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), diff, moves = 0;
        String ori = sc.next(), pass = sc.next();
        char[] original = ori.toCharArray(), password = pass.toCharArray();
        for (int i = 0; i < num; i++) {
            diff = Math.abs(((int) original[i] - 48) - ((int) password[i] - 48));
            if (diff > 5)
                diff = 10 - diff;
            moves += diff;
        }
        System.out.print(moves);
        sc.close();
    }

}
