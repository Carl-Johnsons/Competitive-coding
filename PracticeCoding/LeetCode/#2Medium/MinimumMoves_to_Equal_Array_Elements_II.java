import java.util.Arrays;

public class MinimumMoves_to_Equal_Array_Elements_II {
    public static void main(String[] args) {

    }

    public static int minMoves2(int[] nums) {
        int temp = median(nums);
        int move = 0;
        for (int i = 0; i < nums.length; i++) {
            move += (Math.abs(temp - nums[i]));
        }
        return move;
    }

    public static int median(int arr[]) {
        int len = arr.length;
        Arrays.sort(arr);

        if (len % 2 != 0) {
            return (int) arr[len / 2];
        }
        return (int) (arr[(len - 1) / 2] + arr[len / 2]) / 2;
    }
}
