
//https://codeforces.com/problemset/problem/381/A
import java.util.Scanner;

public class Sereja_and_Dima {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cards, max = 0, max_location = 0, sum_Sereja = 0, sum_Dima = 0;
        boolean Sereja = true, Dima = false;
        cards = sc.nextInt();
        int arr[] = new int[cards];
        for (int i = 0; i < cards; i++) {
            arr[i] = sc.nextInt();
        }
        for (int j = cards; j > 0; j--) {
            max = arr[0];
            max_location = 0;
            if (max < arr[j - 1]) {
                max = arr[j - 1];
                max_location = j - 1;
            }
            if (Sereja) {
                sum_Sereja += max;
                Dima = true;
                Sereja = false;
            } else if (Dima) {
                sum_Dima += max;
                Dima = false;
                Sereja = true;
            }
            if (max_location == 0) {
                for (int a = 1; a < cards; a++)
                    arr[a - 1] = arr[a];
            }

        }
        System.out.print(sum_Sereja + " " + sum_Dima);
        sc.close();

    }
}
