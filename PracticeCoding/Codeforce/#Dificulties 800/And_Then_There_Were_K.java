import java.util.Scanner;

//https://codeforces.com/problemset/problem/1527/A
public class And_Then_There_Were_K {
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
        int value = sc.nextInt();
        int exponentOfTwo = log2(value);
        System.out.println((int) (Math.pow(2, exponentOfTwo)) - 1);
    }

    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }
}
