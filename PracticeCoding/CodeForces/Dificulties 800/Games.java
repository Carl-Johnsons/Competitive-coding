
//https://codeforces.com/problemset/problem/268/A
import java.util.Scanner;

public class Games {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pair = sc.nextInt();
        int count1[] = new int[101], count2[] = new int[101];
        int sum = 0;
        for (int i = 0; i < pair; i++) {
            count1[sc.nextInt()]++;
            count2[sc.nextInt()]++;
        }
        for (int i = 0; i < 101; i++) {
            if (count1[i] >= 1 && count2[i] >= 1) {
                sum += (count1[i] * count2[i]);
            }
        }
        System.out.print(sum);
        sc.close();
    }
}