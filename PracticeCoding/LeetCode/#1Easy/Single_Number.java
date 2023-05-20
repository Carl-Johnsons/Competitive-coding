public class Single_Number {
    public static void main(String[] args) {
        // System.out.println(2 ^ 100 ^ 2 ^ 100 ^ 2 ^ 100 ^ 99);
    }

    public static int singleNumber(int[] nums) {
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            number ^= nums[i];
        }
        return number;
    }
}
