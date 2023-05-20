
public class Sum_of_All_Subset_XOR_Totals {
    static int totalSum = 0;

    public static void main(String[] args) {
        int arr[] = { 5, 1, 6 };
        System.out.println(subsetXORSum(arr));
    }

    public static int subsetXORSum(int[] nums) {
        backTracking(nums, 0, 0);
        return totalSum;
    }

    public static void backTracking(
            int[] nums,
            int start,
            int sumXOR) {
        totalSum += sumXOR;

        for (int i = start; i < nums.length; i++) {
            backTracking(nums, i + 1, sumXOR ^ nums[i]);
        }
    }
}
