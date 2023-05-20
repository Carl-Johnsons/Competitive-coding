public class Max_Consecutive_Ones {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 0, 1, 1, 1 };
        System.out.println(findMaxConsecutiveOnes(arr));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int i = 0, j = 0;
        while (i + j < nums.length) {
            if (nums[i + j] == 0) {
                i++;
                j = 0;
                continue;
            }
            while (i + j < nums.length && nums[i + j] == 1) {
                j++;
            }
            if (max < j) {
                max = j;
            }
            i += j;
            j = 0;
        }
        return max;
    }
}
