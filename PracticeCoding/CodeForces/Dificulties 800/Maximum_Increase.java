
//https://codeforces.com/problemset/problem/702/A
import java.util.Scanner;

public class Maximum_Increase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), max = 0, count = 0, max_length = 0;
        int arr[] = new int[num];
        for (int j = 0; j < num; j++) {
            arr[j] = sc.nextInt();
            if (max < arr[j]) {
                max = arr[j];
                count++;
            } else if (max >= arr[j]) {
                if (max_length < count)
                    max_length = count;
                max = arr[j];
                count = 1;

            }
        }
        if (max_length < count)
            max_length = count;
        System.out.print(max_length);
        sc.close();
    }
}
