
//https://codeforces.com/problemset/problem/431/A
import java.util.Scanner;

public class Black_Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[4], sum = 0;
        for (int i = 0; i < 4; i++)
            arr[i] = sc.nextInt();
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            sum += arr[((int) str.charAt(i)) - 49];
        }
        System.out.print(sum);
        sc.close();
    }

}
