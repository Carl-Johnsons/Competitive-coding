import java.util.Scanner;

//https://codeforces.com/problemset/problem/1742/B
public class Following_Directions {
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
        String path = sc.nextLine();
        boolean pass = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            switch (direction) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
            if (x == 1 && y == 1) {
                pass = true;
            }
        }

        if (pass) {
            res = "YES";
        } else {
            res = "NO";
        }
        System.out.println(res);
    }
}
