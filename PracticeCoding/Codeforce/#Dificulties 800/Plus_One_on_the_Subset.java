
//https://codeforces.com/problemset/problem/1624/A
import java.util.Scanner;

public class Plus_One_on_the_Subset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int n, max = 0, min = 0;
            n = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++)
                arr[j] = sc.nextInt();
            max = arr[0];
            min = arr[0];
            for (int j = 0; j < n; j++) {
                if (max < arr[j])
                    max = arr[j];
                if (min > arr[j])
                    min = arr[j];
            }
            System.out.print(max - min);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }

}
