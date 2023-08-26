
//https://codeforces.com/problemset/problem/1669/A
import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int result, rating = sc.nextInt();
            System.out.print("Division ");
            result = rating >= 1900 ? 1 : rating >= 1600 ? 2 : rating >= 1400 ? 3 : 4;
            System.out.print(result);
            if (i < testcase - 1)
                System.out.println();
        }
        sc.close();
    }
}
