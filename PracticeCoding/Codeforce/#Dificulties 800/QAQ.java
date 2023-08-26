
import java.util.ArrayList;
import java.util.Scanner;
//https://codeforces.com/problemset/problem/894/A

public class QAQ {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        solve();
        sc.close();
    }

    static int res = 0;

    public static void solve() {
        int Q_before_A = 0;
        int Q_after_A = 0;
        ArrayList<Integer> Q_index = new ArrayList<>();
        ArrayList<Integer> A_index = new ArrayList<>();

        String str = sc.nextLine();
        int count_emoji = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'Q')
                Q_index.add(i);
            if (str.charAt(i) == 'A') {
                A_index.add(i);
            }
        }

        if (Q_index.size() < 2 || A_index.isEmpty()) {
            res = 0;
        } else {
            for (int i = 0; i < A_index.size(); i++) {
                Q_before_A = 0;
                Q_after_A = 0;
                for (int j = 0; j < Q_index.size(); j++) {
                    if (Q_index.get(j) < A_index.get(i)) {
                        Q_before_A++;
                    } else {
                        break;
                    }
                }
                Q_after_A = Q_index.size() - Q_before_A;
                count_emoji += (Q_before_A * Q_after_A);
            }
            res = count_emoji;
        }

        System.out.println(res);
    }

}
