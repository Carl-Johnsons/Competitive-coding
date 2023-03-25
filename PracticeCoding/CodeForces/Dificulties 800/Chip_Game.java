import java.util.Scanner;

public class Chip_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            long turn = 0;
            for (int i = 1; i <= 2; i++) {
                long k = sc.nextLong();
                turn += (k % 2) + 1;
            }
            if (turn % 2 == 1)
                System.out.print("Burenka");
            else
                System.out.print("Tonya");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}