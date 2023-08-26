
//https://codeforces.com/problemset/problem/1692/B
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class All_Distinct {
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
        int len = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            int value = sc.nextInt();
            if (set.contains(value))
                count++;
            set.add(value);
        }
        count += (count % 2 == 0 ? 0 : 1);
        res = len - count;
        System.out.println(res);
    }

}
