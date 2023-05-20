public class Jump_Game {
    public static void main(String[] args) {
        int arr[] = { 3, 2, 1, 0, 4 };
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {
        int maximumJump = Integer.MIN_VALUE + 1;
        int cur_index = 0;
        while (cur_index < nums.length && maximumJump != 0) {
            maximumJump--;
            if (maximumJump < nums[cur_index])
                maximumJump = nums[cur_index];
            cur_index++;
        }
        return cur_index == nums.length;
    }
}
