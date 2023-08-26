import java.util.Scanner;

//https://codeforces.com/problemset/problem/1791/A
public class Codeforces_Checking {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = sc.nextInt();
        sc.nextLine();

        match = "codeforces";
        for (int i = 0; i < match.length(); i++) {
            int k = (int) match.charAt(i) - 'a';
            alphabet[k]++;
        }

        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static String match;
    static int alphabet[] = new int[26];
    static String res;

    public static void solve() {
        char temp = sc.nextLine().toCharArray()[0];
        int k = (int) temp - 'a';
        if (alphabet[k] > 0) {
            res = "YES";
        } else {
            res = "NO";
        }
        System.out.println(res);
    }
}
