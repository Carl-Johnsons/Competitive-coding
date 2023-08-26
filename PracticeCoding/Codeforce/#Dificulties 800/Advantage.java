
//https://codeforces.com/problemset/problem/1760/C
import java.util.Scanner;

public class Advantage {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testcase = Integer.parseInt(sc.nextLine());
        while (testcase-- > 0) {
            solve();
        }
        sc.close();
    }

    public static void solve() {
        int len = sc.nextInt();
        int arr[] = new int[len];
        int temparr[] = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            temparr[i] = arr[i];
        }
        sort(temparr);
        int max1 = temparr[temparr.length - 1];
        int max2 = temparr[temparr.length - 2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != max1) {
                System.out.print((arr[i] - max1) + " ");
            } else {
                System.out.print((arr[i] - max2) + " ");
            }
        }
        System.out.println();
    }

    public static void sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        mergeSort(arr, left, right);
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int middle = (left + right) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < L.length; i++) {
            L[i] = arr[left + i];
        }
        for (int i = 0; i < R.length; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
