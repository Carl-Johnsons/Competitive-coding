public class Merge_Sorted_Array {
    public static void main(String[] args) {
        int nums1[] = new int[] { 1, 2, 3, 0, 0, 0 }, m = 3, nums2[] = new int[] { 2, 5, 6 }, n = 3;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + ", ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int arr[] = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while (j < n) {
            arr[k] = nums2[j];
            j++;
            k++;
        }
        System.arraycopy(arr, 0, nums1, 0, m + n);
    }
}
