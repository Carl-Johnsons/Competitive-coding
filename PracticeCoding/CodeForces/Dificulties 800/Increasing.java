import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//https://codeforces.com/problemset/problem/1742/B
public class Increasing {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static String res = "";

    public static void solve() {
        int length = sc.nextInt();

        boolean wrong = false;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            int value = sc.nextInt();
            if (set.contains(value)) {
                wrong = true;
            }
            set.add(value);
        }
        if (!wrong) {
            res = "YES";
        } else {
            res = "NO";
        }
        System.out.println(res);
    }
}
