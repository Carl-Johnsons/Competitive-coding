import java.util.LinkedList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println(findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // Time complexity: O (2n) -> O(n)
        // Space complexity: O (n), If do not count List data structure then it's O (1) 

        List<Integer> missingNumber = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int value = Math.abs(nums[i]) - 1;
            if (nums[value] > 0) // Aboid duplicating the negative number when marking
                nums[value] = -nums[value];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                missingNumber.add(i + 1);
        }
        return missingNumber;
    }
}
