public class Search_Insert_Position {
    public static void main(String[] args) {
        int arr[] = new int[] { 5, 5, 5, 5, 5 };
        int target = 10;
        System.out.println(binarySearch(arr, target, 0, arr.length - 1));
        for (int i = 0; i < arr.length; i++) {
        }
    }

    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        index = binarySearch(nums, target, 0, nums.length - 1);
        return index;
    }

    public static int binarySearch(int arr[], int target, int low, int high) {
        if (low > high) {
            //If can't find the index return the low (the nearest neighbor index)
            return low;
        }

        int mid = (low + high) / 2;
        if (target == arr[mid])
            return mid;
        else if (arr[mid] > target) {
            return binarySearch(arr, target, low, mid - 1);
        }
        return binarySearch(arr, target, mid + 1, high);
    }

}
