// import java.util.Arrays;

public class Find_Triangular_Sum_of_an_Array {
    public static void main(String[] args) {
        int nums[] = { 2, 6, 6, 2, 5, 7 };
        System.out.println(triangularSum(nums));
    }

    public static int triangularSum(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int sum = 0;
        int turn = 0;
        int m = nums.length;
        int n = (m - 1) + 2;
        int newNums[] = new int[m - 1];

        while (m != 1 && n != 1) {
            if (turn == 0) {
                n -= 2;
                for (int j = 0; j < n; j++) {
                    newNums[j] = (nums[j] + nums[j + 1]) % 10;
                }
                sum = newNums[0];
            } else {
                m -= 2;
                for (int j = 0; j < m; j++) {
                    nums[j] = (newNums[j] + newNums[j + 1]) % 10;
                }
                sum = nums[0];
            }
            turn = 1 - turn;
        }
        return sum;
    }
}