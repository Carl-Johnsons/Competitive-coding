
//https://codeforces.com/problemset/problem/749/A
import java.util.Scanner;

public class Bachgold_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number, total = 0, loop = 0;
        number = sc.nextInt();
        loop = total = number / 2;
        if (number % 2 == 1)
            loop--;
        System.out.print(total + "\n");
        if (number > 3) {
            while (loop != 0) {
                System.out.print(2);
                if (loop > 1)
                    System.out.print(" ");
                else if (loop == 1 && number % 2 == 1)
                    System.out.print(" " + 3);
                loop--;

            }
        } else
            System.out.print(number);
        sc.close();
    }

    public static boolean IsPrimeNumber(int x) {
        int count = 0;
        if (x < 2)
            return true;
        else {
            for (int i = 2; i <= Math.sqrt((double) x); i++) {
                if (x % i == 0)
                    count++;
            }
            if (count == 0)
                return true;
            else
                return false;
        }
    }
}
