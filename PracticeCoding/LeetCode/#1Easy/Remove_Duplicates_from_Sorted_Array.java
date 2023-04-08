//https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/928367872/
public class Remove_Duplicates_from_Sorted_Array {
    public static void main(String[] args) {
        int nums[] = new int[] { -100, -100, 0, 99, 100 };
        System.out.println(removeDuplicates(nums));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        int number[] = new int[201]; // 0 means -100, 99 means 0 , 199 means 100
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i] + 100;
            number[value]++;
        }
        for (int i = 0; i < number.length; i++) {
            if (number[i] >= 1) {
                int value = i - 100;
                nums[k] = value;
                k++;
            }
        }
        return k;
    }
}
