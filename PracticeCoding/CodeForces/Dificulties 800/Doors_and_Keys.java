
//https://codeforces.com/problemset/problem/1644/A
import java.util.Scanner;

public class Doors_and_Keys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            boolean red = false, green = false, blue = false, okay = true;
            String s = sc.next();
            char[] str = s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                if (str[i] == 'r')
                    red = true;
                else if (str[i] == 'g')
                    green = true;
                else if (str[i] == 'b')
                    blue = true;
                if ((str[i] == 'R' && !red) || (str[i] == 'G' && !green) || (str[i] == 'B' && !blue)) {
                    okay = false;
                    break;
                }
            }
            if (okay)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
