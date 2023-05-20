public class Maximum_Product_of_Three_Numbers {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 2 };
        System.out.println(maximumProduct(arr));
    }

    public static int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE,
                max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if (min2 > nums[i]) {
                min2 = nums[i];
            }
            if (max1 < nums[i]) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (max2 < nums[i]) {
                max3 = max2;
                max2 = nums[i];
            } else if (max3 < nums[i]) {
                max3 = nums[i];
            }
        }
        int last3 = max1 * max2 * max3;
        int front2last1 = min1 * min2 * max1;
        return (last3 > front2last1 ? last3 : front2last1);
    }
}
