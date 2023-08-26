
//https://codeforces.com/problemset/problem/1741/A
import java.util.Scanner;

public class Compare_T_Shirt_Sizes {
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
        String str = sc.nextLine();
        String strSplit[] = str.split(" ");
        String a = strSplit[0], b = strSplit[1];
        if (a.equals(b)) {
            res = "=";
        } else {
            char suffixA = a.charAt(a.length() - 1);
            char suffixB = b.charAt(b.length() - 1);
            // The bigger the size, the smaller the Ascii's value
            if (suffixA < suffixB) {
                res = ">";
            } else if (suffixA > suffixB) {
                res = "<";
            } else {
                if (suffixA == 'S') {
                    if (a.length() > b.length()) {
                        res = "<";
                    } else {
                        res = ">";
                    }
                } else if (suffixA == 'L') {
                    if (a.length() > b.length()) {
                        res = ">";
                    } else {
                        res = "<";
                    }
                }
            }
        }
        System.out.println(res);
    }

}