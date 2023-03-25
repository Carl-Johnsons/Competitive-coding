
//https://codeforces.com/problemset/problem/1311/A
import java.util.Scanner;

public class Add_Odd_or_Subtract_Even {
    public static void main(String[] args) {
        long testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextLong();
        for (long i = 0; i < testcase; i++) {
            long a, b, moves = 0;
            a = sc.nextLong();
            b = sc.nextLong();
            if (a < b) {

                if (b == a)
                    moves = 0;
                else if ((b - a) % 2 == 1)
                    moves = 1;
                else
                    moves = 2;
            } else {
                if (b == a)
                    moves = 0;
                else if ((b - a) % 2 == 0)
                    moves = 1;
                else
                    moves = 2;
            }
            System.out.print(moves);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }

}
