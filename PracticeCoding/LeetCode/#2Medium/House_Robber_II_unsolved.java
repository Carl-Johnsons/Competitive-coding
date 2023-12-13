//https://leetcode.com/problems/house-robber-ii/description/
public class House_Robber_II_unsolved {
    public static void main(String[] args) {
        int[] nums;
        // nums = new int[] { 1, 2, 3, 1 };
        nums = new int[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        int max[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max[i] = -1;
        }
        helper(nums, max, nums.length - 1);
        // The answer should be in the frst 3 element of max array
        return Math.max(max[0], Math.max(max[1], max[2]));
    }

    public static void helper(int[] nums, int max[], int index) {
        if (index < 0) {
            return;
        }
        // 2 case at the last index
        if (index == nums.length - 1 || index == nums.length - 2) {
            max[index] = nums[index];
            helper(nums, max, index - 1);
            return;
        }
        int evenPath = 0;
        int oddPath = 0;

        if (index + 2 < nums.length) {
            evenPath = max[index + 2];
        }
        if (index + 3 < nums.length) {
            oddPath = max[index + 3];
        }
        max[index] = nums[index] + Math.max(evenPath, oddPath);
        if (index == 0) {
            if (nums[nums.length - 1] > nums[nums.length - 2]) {
                max[index] -= nums[nums.length - 1];
            }
            // if(nums[nums.length-1]  )
        }

        helper(nums, max, index - 1);
    }
}