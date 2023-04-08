public class Squares_of_a_Sorted_Array {
    public static void main(String[] args) {
        int nums[] = new int[] { -4, -1, 0, 3, 10 };
        nums = sortedSquares(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int j = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            j = 0;
            if (Math.abs(nums[i]) < Math.abs(nums[0])) {
                int temp = nums[0];
                while (j < i) {
                    nums[j] = nums[j + 1];
                    j++;
                }
                nums[i] = temp;
            }
            nums[i] *= nums[i];
        }
        return nums;
    }
}
