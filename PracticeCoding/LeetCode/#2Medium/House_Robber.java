
public class House_Robber {
    public static void main(String[] args) {
        int[] nums;
        nums = new int[] { 1, 2, 3, 1 };
        // nums = new int[] { 2, 1, 1, 2 };
        // nums = new int[] { 2, 7, 9, 3, 1 };

        System.out.println(rob(nums));
    }

    // public static int rob(int[] nums) {
    // if (nums.length == 1) {
    // return nums[0];
    // }
    // int max[] = new int[nums.length];
    // for (int i = 0; i < nums.length; i++) {
    // max[i] = -1;
    // }
    // helper(nums, max, nums.length - 1);
    // // The answer should be in the frst 2 element of max array
    // return Math.max(max[0], max[1]);
    // }

    // public static void helper(int[] nums, int max[], int index) {
    // if (index < 0) {
    // return;
    // }
    // // 2 case at the last index
    // if (index == nums.length - 1 || index == nums.length - 2) {
    // max[index] = nums[index];
    // helper(nums, max, index - 1);
    // return;
    // }
    // int evenPath = 0;
    // int oddPath = 0;

    // if (index + 2 < nums.length) {
    // evenPath = max[index + 2];
    // }
    // if (index + 3 < nums.length) {
    // oddPath = max[index + 3];
    // }
    // max[index] = nums[index] + Math.max(evenPath, oddPath);
    // helper(nums, max, index - 1);
    // }

    // ===================== TABULATION METHOD =================================
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int tabulation[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tabulation[i] = -1;
        }
        tabulation[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            tabulation[i] = Math.max(tabulation[i], nums[i]);
            if (i + 2 < nums.length) {
                tabulation[i + 2] = Math.max(tabulation[i] + nums[i + 2], tabulation[i + 2]);
            }
            if (i + 3 < nums.length) {
                tabulation[i + 3] = Math.max(tabulation[i] + nums[i + 3], tabulation[i + 3]);
            }
        }
        // The output should be the last 2 elements
        return Math.max(tabulation[nums.length - 1], tabulation[nums.length - 2]);
    }

}