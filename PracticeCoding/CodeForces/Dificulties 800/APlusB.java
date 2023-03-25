
import java.util.Scanner;

//https://codeforces.com/problemset/problem/1772/A
public class APlusB {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    public static void solve() {
        String expression = sc.nextLine();
        String operands[] = expression.split("[+]");

        System.out.println(Integer.parseInt(operands[0]) + Integer.parseInt(operands[1]));

    }
}
