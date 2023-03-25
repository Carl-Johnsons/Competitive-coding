
//https://codeforces.com/problemset/problem/1622/A
import java.util.Scanner;

public class Construct_a_Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            long arr[] = new long[3], sum = 0, giong_nhau = 0, num = 0;
            boolean okay = false;
            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextLong();
                sum += arr[i];
            }
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (arr[i] == arr[j]) {
                        giong_nhau++;
                        num = arr[i];
                    }
                }
            }
            if (giong_nhau >= 2) {
                if (arr[0] % 2 == 0)
                    okay = true;
            } else if (giong_nhau == 1) {
                for (int i = 0; i < 3; i++) {
                    if (arr[i] != num && arr[i] % 2 == 0) {
                        okay = true;
                    }
                }
            } else if (giong_nhau == 0) {
                for (int i = 0; i < 3; i++) {
                    if (sum / 2 == arr[i] && sum % 2 == 0) {
                        okay = true;
                    }
                }
            }
            if (okay)
                System.out.print("YES");
            else
                System.out.print("NO");
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
