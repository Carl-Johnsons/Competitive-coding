import java.util.Arrays;

public class Counting_Bits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(15)));
    }

    public static int[] countBits(int n) {
        int arr[] = new int[n + 1];
        int offset = 1;
        for (int i = 1; i < arr.length; i++) {
            if (offset * 2 == i)
                offset *= 2;
            arr[i] = 1 + arr[i - offset];
        }
        return arr;
    }

}
