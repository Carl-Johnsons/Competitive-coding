import java.util.Arrays;

public class Move_Zeroes {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 3, 12 };
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length == 1)
            return;
        int startZero = -1, temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && startZero == -1) {
                startZero = i;
            } else if (nums[i] == 0 && startZero != -1) {
                continue;
            }

            if (nums[i] != 0 && startZero != -1) {
                temp = nums[startZero];
                nums[startZero] = nums[i];
                nums[i] = temp;
                startZero++;
            }
        }
    }
}
