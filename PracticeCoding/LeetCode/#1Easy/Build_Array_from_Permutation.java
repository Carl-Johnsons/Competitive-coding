public class Build_Array_from_Permutation {
    public static void main(String[] args) {

    }

    public static int[] buildArray(int[] nums) {
        int arr[] = new int[nums.length];
        for (int index = 0; index < arr.length; index++) {
            arr[index] = nums[nums[index]];
        }
        return arr;
    }
}
