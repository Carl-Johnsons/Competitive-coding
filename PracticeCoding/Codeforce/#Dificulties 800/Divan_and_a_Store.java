import java.util.Scanner;
import java.util.Arrays;

//https://codeforces.com/problemset/problem/1614/A
public class Divan_and_a_Store {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testase = sc.nextInt();
        while (testase-- != 0) {
            long count = 0;
            int shops = sc.nextInt();
            long cheap = sc.nextLong(), expensive = sc.nextLong(), current_money = sc.nextLong();
            long arr[] = new long[shops];
            for (int i = 0; i < shops; i++) {
                arr[i] = sc.nextLong();
            }
            Arrays.sort(arr);
            for (int i = 0; i < shops; i++) {
                if (arr[i] >= cheap && arr[i] <= expensive) {
                    if (current_money < arr[i])
                        break;
                    else {
                        current_money -= arr[i];
                        count++;
                    }
                }
            }
            System.out.print(count);
            if (testase > 0)
                System.out.println();
        }
        sc.close();
    }
}
