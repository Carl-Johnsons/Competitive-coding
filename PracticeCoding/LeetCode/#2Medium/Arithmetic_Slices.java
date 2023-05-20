public class Arithmetic_Slices {
    public static void main(String[] args) {
        int arr[] = { -7, 0, 7, 10, 10, 10, 10, 0 };
        System.out.println(numberOfArithmeticSlices(arr));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;
        int prev_diff = nums[1] - nums[0], curdiff, sum = 0, index = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            curdiff = nums[i + 1] - nums[i];
            if (curdiff == prev_diff)
                index++;
            else {
                prev_diff = curdiff;
                index = 0;
            }
            sum += index;
        }
        return sum;
    }
}
