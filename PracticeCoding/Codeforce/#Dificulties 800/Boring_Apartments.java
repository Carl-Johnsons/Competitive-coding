
//https://codeforces.com/problemset/problem/1433/A
import java.util.Scanner;

public class Boring_Apartments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int number, count = 0;
            number = sc.nextInt();
            int donvi = number % 10;
            for (int j = 1; j < donvi; j++) {
                count += 10;
            }
            for (int j = 1; j <= digit(number); j++)
                count += j;
            System.out.print(count);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }

    public static int digit(int x) {
        int count = 0;
        while (x != 0) {
            x /= 10;
            count++;
        }
        return count;
    }

}
