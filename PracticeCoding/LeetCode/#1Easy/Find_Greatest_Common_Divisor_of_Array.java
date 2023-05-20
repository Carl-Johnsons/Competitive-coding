public class Find_Greatest_Common_Divisor_of_Array {
    public static void main(String[] args) {

    }

    public static int findGCD(int[] nums) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i])
                max = nums[i];
            if (min > nums[i])
                min = nums[i];
        }
        return GCD(max, min);

    }

    public static int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

}
