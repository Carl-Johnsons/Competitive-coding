public class Single_Number_II {
    public static void main(String[] args) {
        int arr[] = { 2, 2, 3, 2, 1, 3, 3 };
        System.out.println(singleNumber(arr));
        System.out.println((2 & (2 >> 1)) & 2);
    }

    public static int singleNumber(int[] nums) {
        int num = nums[0];
        int turn = 0;
        for (int i = 1; i < nums.length; i++) {
            num ^= (nums[i] >> 1) << 1;
            turn = 1 - turn;
        }
        return num;
    }
}
