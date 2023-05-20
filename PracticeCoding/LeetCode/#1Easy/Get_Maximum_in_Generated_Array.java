import java.util.Arrays;

public class Get_Maximum_in_Generated_Array {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            System.out.println("loop: " + i);
            getMaximumGenerated(i);
        }
    }

    public static int getMaximumGenerated(int n) {
        if (n < 2)
            return n;
        int arr[] = new int[n + 1];
        int max = Integer.MIN_VALUE;

        arr[0] = 0;
        arr[1] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2 && 2 * i + j < arr.length; j++) {
                arr[2 * i + j] = arr[i] + arr[i + 1] * j;
                if (max < arr[2 * i + j])
                    max = arr[2 * i + j];
            }
        }
        System.out.println(Arrays.toString(arr));
        return max;
    }
}
