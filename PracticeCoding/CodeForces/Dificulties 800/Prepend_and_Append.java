import java.util.Scanner;

//https://codeforces.com/problemset/problem/1791/C
public class Prepend_and_Append {
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
        String binary_str = sc.nextLine();

        int start = 0;
        int end = len - 1;
        for (int i = 0; i < binary_str.length() / 2; i++) {
            char start_char = binary_str.charAt(start);
            char end_char = binary_str.charAt(end);

            if (start_char != end_char) {
                len -= 2;
                start++;
                end--;
            }
        }
        System.out.println(len);
    }
}
