import java.util.Scanner;

//https://codeforces.com/problemset/problem/716/A
public class Crazy_Computer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        long c = sc.nextLong();
        long count;
        count = 1;
        long previous = sc.nextLong();
        for (int i = 1; i < len; i++) {
            long current = sc.nextLong();
            if (current - previous > c) {
                count = 0;
            }
            count++;
            previous = current;
        }
        System.out.print(count);
        sc.close();
    }
}
