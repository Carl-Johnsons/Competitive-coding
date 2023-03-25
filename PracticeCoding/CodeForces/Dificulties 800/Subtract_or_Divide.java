
//https://codeforces.com/problemset/problem/1451/A
import java.util.Scanner;

public class Subtract_or_Divide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            long num = sc.nextLong();
            int moves = 0;
            while (num != 1) {
                long temp = num / 2;
                if (num % temp == 0 && temp != 1) {
                    moves += 1;
                    num /= temp;
                } else if (num % (temp * 2) == 0 && (temp * 2) != 1) {
                    moves += 1;
                    num /= (temp * 2);
                } else {
                    moves += (num - (temp * 2));
                    num -= (num - (temp * 2));
                }
            }
            System.out.print(moves);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
