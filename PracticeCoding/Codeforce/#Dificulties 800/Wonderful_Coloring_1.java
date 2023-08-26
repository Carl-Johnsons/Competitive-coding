
//https://codeforces.com/problemset/problem/1551/B1
import java.util.Scanner;

public class Wonderful_Coloring_1 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static long res = 0;

    public static void solve() {
        String str = sc.nextLine();
        int alphabet[] = new int[26];
        for (int i = 0; i < str.length(); i++) {
            int k = (int) str.charAt(i) - 'a';
            alphabet[k]++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[i] > alphabet[j]) {
                    int temp = alphabet[i];
                    alphabet[i] = alphabet[j];
                    alphabet[j] = temp;
                }
            }
        }
        int red = 0, green = 0;
        int turn = 0; // 0 is red, 1 is green
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 0) {
                break;
            }
            if (alphabet[i] >= 2) {
                red++;
                green++;
            }
            if (alphabet[i] == 1) {
                if (turn == 0) {
                    red++;
                } else {
                    green++;
                }
                turn = 1 - turn;
            }
        }
        res = red;
        if (res > green)
            res = green;
        System.out.println(res);
    }

}
