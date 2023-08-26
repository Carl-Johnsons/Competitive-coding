
//https://codeforces.com/problemset/problem/1399/B
import java.util.Scanner;

public class Gifts_Fixing {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int n;
            n = sc.nextInt();
            long arrA[] = new long[n], arrB[] = new long[n], minA, minB, moves = 0, movesA = 0, movesB = 0, sum = 0;
            for (int j = 0; j < n; j++)
                arrA[j] = sc.nextLong();
            for (int j = 0; j < n; j++)
                arrB[j] = sc.nextLong();
            minA = arrA[0];
            minB = arrB[0];
            for (int j = 0; j < n; j++) {
                if (minA > arrA[j])
                    minA = arrA[j];
                if (minB > arrB[j])
                    minB = arrB[j];
            }
            for (int j = 0; j < n; j++) {
                movesA = 0;
                movesB = 0;
                moves = 0;
                if (arrA[j] != minA)
                    movesA = Math.abs(arrA[j] - minA);
                if (arrB[j] != minB)
                    movesB = Math.abs(arrB[j] - minB);
                moves = movesA;
                if (moves < movesB)
                    moves = movesB;
                sum += moves;
            }
            System.out.print(sum);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
