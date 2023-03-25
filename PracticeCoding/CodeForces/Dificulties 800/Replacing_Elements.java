
//https://codeforces.com/problemset/problem/1473/A
import java.util.Scanner;

public class Replacing_Elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int n = sc.nextInt(), d = sc.nextInt(), min = 0, min2 = 100000, min_location = 0;
            int arr[] = new int[n];
            Boolean okay = true;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (i == 0) {
                    min = arr[0];
                } else {
                    if (arr[i] < min) {
                        min = arr[i];
                        min_location = i;
                    }
                }
                if (arr[i] > d)
                    okay = false;
            }
            if (okay)
                System.out.print("YES");
            else {
                for (int i = 0; i < n; i++) {
                    if (arr[i] < min2 && i != min_location)
                        min2 = arr[i];
                }
                if (min + min2 > d || min2 >= d || min >= d)
                    System.out.print("NO");
                else
                    System.out.print("YES");
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
