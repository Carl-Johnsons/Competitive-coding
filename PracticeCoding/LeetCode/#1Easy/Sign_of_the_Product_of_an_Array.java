public class Sign_of_the_Product_of_an_Array {
    public static void main(String[] args) {

    }

    public static int arraySign(int[] nums) {
        int Sign = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                return 0;
            if (nums[i] < 0) {
                Sign *= -1;
            }
        }
        return Sign;
    }
}
