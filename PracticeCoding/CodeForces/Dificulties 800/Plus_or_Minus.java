import java.util.Scanner;

//https://codeforces.com/problemset/problem/1807/A
public class Plus_or_Minus {
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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = sc.nextInt();
        if (result >= a && result >= b) {
            res = "+";
        } else {
            res = "-";
        }
        System.out.println(res);
    }
}
