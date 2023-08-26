
//https://codeforces.com/problemset/problem/1478/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Nezzar_and_Colorful_Balls {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            solve();
        }
        sc.close();
    }

    static int res = 0;

    public static void solve() {
        int max = -1;
        int len = sc.nextInt();
        Map<Integer, Integer> Occurences = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int value = sc.nextInt();
            Occurences.merge(value, 1, Integer::sum);
            if (Occurences.get(value) > max) {
                max = Occurences.get(value);
            }
        }
        res = max;
        System.out.println( res);
    }

}