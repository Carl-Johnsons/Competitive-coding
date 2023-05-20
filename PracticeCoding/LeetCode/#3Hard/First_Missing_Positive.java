
public class First_Missing_Positive {
    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 4 };
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > len) {
                nums[i] = len + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num > len) {
                continue;
            }
            num--;
            if (nums[num] > 0) {
                nums[num] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        return len + 1;
    }
}