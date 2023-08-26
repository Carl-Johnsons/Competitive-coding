
//https://codeforces.com/problemset/problem/1519/A
import java.util.Scanner;

public class Red_and_Blue_Beans {
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
        long redBeans = sc.nextLong();
        long blueBeans = sc.nextLong();
        long differences = sc.nextLong();
        boolean check = false;

        if (Math.abs(redBeans - blueBeans) <= differences) {
            res = "YES";
        } else
        {
            //Math.min(redBeans, blueBeans) * (differences + 1) mean the the min bean allowed in each bags
            check = Math.max(redBeans, blueBeans) <= Math.min(redBeans, blueBeans) * (differences + 1);
            if (check) {
                res = "YES";
            } else {
                res = "NO";
            }
        }
        System.out.println(res);
    }

}
