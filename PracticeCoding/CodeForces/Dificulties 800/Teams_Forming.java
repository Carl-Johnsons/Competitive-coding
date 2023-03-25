
//https://codeforces.com/problemset/problem/1092/B
import java.util.Scanner;
import java.util.Arrays;

public class Teams_Forming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(), sum = 0;
        int student[] = new int[len];
        for (int i = 0; i < len; i++) {
            student[i] = sc.nextInt();
        }
        Arrays.sort(student);
        for (int i = 0; i < len; i += 2) {
            sum += (Math.abs(student[i] - student[i + 1]));
        }
        System.out.print(sum);
        sc.close();
    }
}
