//https://codeforces.com/problemset/problem/1353/B
import java.util.Scanner;

public class Two_Arrays_And_Swaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase;
        testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int sum = 0, temp, number, move, max, max_location = 0, min, min_location = 0;
            number = sc.nextInt();
            move = sc.nextInt();
            int arrA[] = new int[number];
            int arrB[] = new int[number];
            for (int j = 0; j < number; j++) {
                arrA[j] = sc.nextInt();
            }
            for (int j = 0; j < number; j++) {
                arrB[j] = sc.nextInt();
            }

            for (int a = 0; a < move; a++) {
                max = arrB[0];
                min = arrA[0];
                max_location = 0;
                min_location = 0;
                for (int j = 0; j < number; j++) {
                    if (max < arrB[j]) {
                        max = arrB[j];
                        max_location = j;
                    }
                    if (min > arrA[j]) {
                        min = arrA[j];
                        min_location = j;
                    }
                }
                if (max >= min) {
                    temp = arrA[min_location];
                    arrA[min_location] = arrB[max_location];
                    arrB[max_location] = temp;
                }
            }
            for (int j = 0; j < number; j++) {
                sum += arrA[j];
            }
            System.out.print(sum);
            if (i < testcase - 1)
                System.out.print("\n");
        }
        sc.close();
    }

}
