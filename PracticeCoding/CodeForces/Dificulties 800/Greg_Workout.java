
//https://codeforces.com/problemset/problem/255/A
import java.util.Scanner;

public class Greg_Workout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count[] = new int[3], max_location = 0;
        int len = sc.nextInt();
        for (int i = 0; i < len; i++) {
            int k = sc.nextInt();
            count[i % 3] += k;
        }
        for (int i = 0; i < 3; i++) {
            if (count[max_location] < count[i])
                max_location = i;
        }
        String result = max_location == 0 ? "chest" : max_location == 1 ? "biceps" : "back";
        System.out.print(result);
        sc.close();
    }
}