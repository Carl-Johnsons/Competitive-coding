
//https://codeforces.com/problemset/problem/1703/A
import java.util.Scanner;

public class YES_or_YES {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        String yes = "yes";
        for (int i = 0; i < testcase; i++) {
            String str = sc.next();
            if (str.toLowerCase().compareTo(yes) == 0)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
