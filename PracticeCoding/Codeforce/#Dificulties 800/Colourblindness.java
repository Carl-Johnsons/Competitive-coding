import java.util.Scanner;

//https://codeforces.com/problemset/problem/1722/B
public class Colourblindness {
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
        int length = Integer.parseInt(sc.nextLine());
        boolean wrongColor = false;

        String str = sc.nextLine();
        String str2 = sc.nextLine();

        for (int i = 0; i < length; i++) {
            char a = str.charAt(i);
            char b = str2.charAt(i);
            if ((a == 'R' || b == 'R') && (a != b))
                wrongColor = true;
        }

        if (!wrongColor) {
            res = "YES";
        } else {
            res = "NO";
        }
        System.out.println(res);
    }
}
