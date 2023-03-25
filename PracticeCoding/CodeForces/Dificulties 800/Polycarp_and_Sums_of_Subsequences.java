
//https://codeforces.com/problemset/problem/1618/A
import java.util.Scanner;

public class Polycarp_and_Sums_of_Subsequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long arr[] = new long[7], max = 0, suitable[] = new long[3];
            boolean thoat = false;
            for (int i = 0; i < 7; i++) {
                arr[i] = sc.nextLong();
                if (max < arr[i])
                    max = arr[i];
            }
            for (int i = 0; i < 7; i++) {
                for (int j = i + 1; j < 7; j++) {
                    for (int k = j + 1; k < 7; k++) {
                        if (arr[i] + arr[j] + arr[k] == max) {
                            suitable[0] = arr[i];
                            suitable[1] = arr[j];
                            suitable[2] = arr[k];
                            break;
                        }
                    }
                    if (thoat)
                        break;
                }
                if (thoat)
                    break;
            }
            for (int i = 0; i < 3; i++) {
                System.out.print(suitable[i]);
                if (i < 2)
                    System.out.print(" ");
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
