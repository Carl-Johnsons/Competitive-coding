import java.util.Arrays;

public class Form_Smallest_Number_From_Two_Digit_Arrays {
    public static void main(String[] args) {
        int[] nums1 = { 4, 1, 3 }, nums2 = { 5, 7 };
        System.out.println(minNumber(nums1, nums2));
    }

    public static int minNumber(int[] nums1, int[] nums2) {
        int hashtable[] = new int[10], min1 = Integer.MAX_VALUE;

        for (int i = 0; i < nums1.length; i++) {
            hashtable[nums1[i]]++;
            if (min1 > nums1[i])
                min1 = nums1[i];
        }
        Arrays.sort(nums2);
        for (int i = 0; i < nums2.length; i++) {
            if (hashtable[nums2[i]] == 1) {
                return nums2[i];
            }
        }
        return Math.min(min1, nums2[0]) * 10 + Math.max(min1, nums2[0]);
    }
}
