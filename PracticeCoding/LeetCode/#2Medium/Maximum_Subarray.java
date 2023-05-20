public class Maximum_Subarray {
    public static void main(String[] args) {
        int arr[] = { -1 };
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0, maxSoFar = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSoFar) {
                maxSoFar = sum;
            }
            if (sum <= 0) {
                if (nums[i] > sum)
                    sum = nums[i];
                else
                    sum = 0;
            }
        }

        return maxSoFar;
    }
}
