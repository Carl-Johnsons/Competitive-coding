
//https://codeforces.com/problemset/problem/1692/A
import java.util.Scanner;

public class Marathon {
    public static void main(String[] args) {
        int testcase;
        Scanner sc = new Scanner(System.in);
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int arr[] = new int[4], in_front_of = 0;
            for (int j = 0; j < 4; j++)
                arr[j] = sc.nextInt();
            for (int j = 1; j < 4; j++) {
                if (arr[0] < arr[j])
                    in_front_of++;
            }
            System.out.print(in_front_of);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }
}
