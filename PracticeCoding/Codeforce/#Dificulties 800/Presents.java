
//https://codeforces.com/problemset/problem/136/A
import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int result[] = new int[len];
        for (int i = 0; i < len; i++) {
            result[sc.nextInt() - 1] = i + 1;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(result[i] + " ");
        }
        sc.close();
    }
}
