
//https://codeforces.com/problemset/problem/1537/A
import java.util.Scanner;

public class Arithmetic_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        while (testcase != 0) {
            testcase--;
            int num = sc.nextInt(), sum = 0;
            int arr[] = new int[num];
            for (int i = 0; i < num; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            if (sum / num <= 0)
                System.out.print(1);
            else {
                System.out.print(sum - num);
            }
            if (testcase > 0)
                System.out.println();
        }
        sc.close();
    }
}
