public class Binary_Search {
    public static void main(String[] args) {
        int arr[] = new int[] { -1, 0, 3, 5, 9, 12 };
        int target = 0;

        System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int binarySearch(int[] num, int target, int low, int high) {
        /* Recursion method */
        // if (low > high) {
        // return -1;
        // }
        // int mid = (low + high) / 2;
        // if (num[mid] == target)
        // return mid;
        // if (num[mid] > target)
        // return binarySearch(num, target, low, mid - 1);
        // return binarySearch(num, target, mid + 1, high);

        /*
         * Iterate method: Space complexity O(1) while keeping the Time Complexity
         * O(logn) unlike Recursion method
         */
        while (low <= high) {
            int mid = (low + high) / 2;
            if (num[mid] == target)
                return mid;
            if (num[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
