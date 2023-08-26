import java.util.Scanner;

//https://codeforces.com/problemset/problem/1574/A
public class Regular_Bracket_Sequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testase = sc.nextInt();
        while (testase-- != 0) {
            int len = sc.nextInt();
            int a = len;
            int b = 0;
            while (len-- != 0) {
                for (int i = 0; i < a * 2; i++) {
                    System.out.print(i < a ? "(" : ")");
                }
                for (int j = 0; j < b * 2; j++) {
                    System.out.print(j < b ? "(" : ")");
                }
                a--;
                b++;
                if (len > 0)
                    System.out.println();
            }
            if (testase > 0)
                System.out.println();
        }

        sc.close();
    }
}