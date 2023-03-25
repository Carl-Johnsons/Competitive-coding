import java.util.Scanner;

//https://codeforces.com/problemset/problem/1760/B
public class Atilla_s_Favorite_Problem {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    public static void solve() {
        int len = Integer.parseInt(sc.nextLine());

        String str = sc.nextLine();

        int max_char = 0;
        for (int i = 0; i < len; i++) {
            int word_to_learn = ((int) str.charAt(i) - 'a') + 1;
            if (max_char < word_to_learn) {
                max_char = word_to_learn;
            }
        }
        System.out.println(max_char);
    }
}
