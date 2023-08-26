
//https://codeforces.com/problemset/problem/1631/A
import java.util.Scanner;

public class Min_Max_Swap {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    static long res = 0;

    public static void solve() {
        int len = sc.nextInt();
        int arrA[] = new int[len];
        int arrB[] = new int[len];
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = sc.nextInt();
        }

        swapIndices(arrA, arrB);
        res = maxOf(arrA) * maxOf(arrB);
        System.out.println(res);
    }

    static int maxIndex = -1;

    public static int maxOf(int arr[]) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return max;
    }

    public static void swapIndices(int arrA[], int arrB[]) {
        while (maxOf(arrB) > arrA[maxIndex]) {
            int temp = arrB[maxIndex];
            arrB[maxIndex] = arrA[maxIndex];
            arrA[maxIndex] = temp;
        }
    }
}
