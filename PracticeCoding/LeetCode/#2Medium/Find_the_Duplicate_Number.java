public class Find_the_Duplicate_Number {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(arr));
        System.out.println((~3 ^ ~2) ^ 2);
    }

    public static int findDuplicate(int[] nums) {
        int n = ~nums[0];
        for (int i = 1; i < nums.length; i++) {
            n ^= ~nums[i];
        }
        return n;
    }
}
