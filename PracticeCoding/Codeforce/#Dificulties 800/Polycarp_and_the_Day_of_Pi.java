import java.util.Scanner;

//https://codeforces.com/problemset/problem/1790/A
public class Polycarp_and_the_Day_of_Pi {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static String PI = "314159265358979323846264338327";

    public static void solve() {
        String str = sc.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (PI.charAt(i) != str.charAt(i))
                break;
            count++;
        }
        System.out.println(count);
    }

}
