public class Remove_Element {
    public static void main(String[] args) {
        int nums[] = new int[] { 4, 5 };
        int val = 5;
        System.out.println(removeElement(nums, val));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }

    public static int removeElement(int[] nums, int val) {
        int k = nums.length;
        int j = nums.length - 1;
        int i = 0;
        while (i < nums.length && i <= j) {
            if (nums[i] == val) {
                while (j >= 0 && nums[j] == val) {
                    j--;
                    k--;
                }
                if (j >= 0 && i <= j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j--;
                    k--;
                }
            }
            i++;
        }
        return k;
    }
}
