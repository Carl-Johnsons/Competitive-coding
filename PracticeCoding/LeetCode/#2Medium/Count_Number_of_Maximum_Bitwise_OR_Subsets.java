

public class Count_Number_of_Maximum_Bitwise_OR_Subsets {
    static int count = 0;

    public static void main(String[] args) {
        int arr[] = { 3, 2, 1, 5 };
        System.out.println(countMaxOrSubsets(arr));
    }

    public static int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max |= nums[i];
        }
        backTracking(nums, max, 0, 0);
        return count;
    }

    public static void backTracking(
            int nums[],
            int max,
            int sumOR,
            int start) {
        if (sumOR == max) {
            count++;
        }

        for (int i = start; i < nums.length; i++) {
            backTracking(nums, max, sumOR | nums[i], i + 1);
        }
    }
}