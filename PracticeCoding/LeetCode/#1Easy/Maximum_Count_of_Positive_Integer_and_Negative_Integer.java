//https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/submissions/928979289/

public class Maximum_Count_of_Positive_Integer_and_Negative_Integer {
    public static void main(String[] args) {
        int nums[] = new int[] { -1, -1, -2 };
        System.out.println(maximumCount(nums));
    }

    public static int maximumCount(int[] nums) {
        int max = 0;

        /* O(n) method */

        // LinkedList<Integer> pos = new LinkedList<>();
        // LinkedList<Integer> neg = new LinkedList<>();

        // for (int i = 0; i < nums.length; i++) {
        // if (nums[i] > 0) {
        // pos.add(nums[i]);
        // } else if (nums[i] < 0) {
        // neg.add(nums[i]);
        // }
        // }
        // max = (pos.size() > neg.size() ? pos.size() : neg.size());

        /* O(logn) method */

        int center = binarySearchCenter(nums, 0, nums.length - 1);
        // System.out.println(center);
        center++; // center is the index that have negative number and next to is a value that >=0
        int neg = center;
        for (int i = center; i < nums.length; i++) {
            if (nums[i] == 0)
                center++;
            else
                break;
        }
        int pos = nums.length - center;
        max = (pos > neg ? pos : neg);
        // System.out.println(neg + " " + pos);
        return max;
    }

    public static int binarySearchCenter(int[] arr, int low, int high) {
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] < 0 && mid + 1 < arr.length && arr[mid + 1] >= 0)
                return mid;
            if (arr[mid] >= 0)
                high = mid - 1;
            else if (arr[mid] < 0)
                low = mid + 1;
        }
        // Return if the array don't have negative number
        // System.out.println("Low: " + low + " |" + "High: " + high);
        if (low == arr.length || high == arr.length) {
            return arr.length - 1;
        }
        return -1;
    }
}
