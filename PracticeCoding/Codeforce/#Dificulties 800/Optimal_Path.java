
//https://codeforces.com/problemset/problem/1700/A
import java.util.Scanner;

public class Optimal_Path {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase-- != 0) {
            long hang = sc.nextLong(), cot = sc.nextLong(), sum = 0;
            long somax = 0;
            sum = cot * (cot + 1) / 2;
            sum -= cot;
            // cap so cong
            somax = cot + (hang - 1) * cot;
            sum += (cot + somax) * hang / 2;
            System.out.print(sum);
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
