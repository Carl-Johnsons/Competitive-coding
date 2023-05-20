public class Missing_Number {
    public static void main(String[] args) {

    }

    public static int missingNumber(int[] nums) {
        int len = nums.length;
        int sumArray = 0;
        int sumFrom0ToLen = ((1 + len) * len) / 2;
        for (int i = 0; i < nums.length; i++) {
            sumArray += nums[i];
        }
        return sumFrom0ToLen - sumArray;
    }
}
