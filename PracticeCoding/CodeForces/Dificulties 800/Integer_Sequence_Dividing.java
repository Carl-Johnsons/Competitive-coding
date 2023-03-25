//https://codeforces.com/problemset/problem/1102/A

import java.util.Scanner;

public class Integer_Sequence_Dividing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.print((n * (n + 1) / 2) % 2);
        sc.close();
    }
}
