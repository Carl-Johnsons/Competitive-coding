import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
    public static void main(String[] args) {
        int nums[] = new int[] {2, 3, 3, 2 };
        System.out.println(twoSum(nums, 6)[0] + " " + twoSum(nums, 6)[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];

        res[0] = -1;
        res[1] = -1;

        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
            res[0] = i;

            if (res[1] != -1 && nums[res[0]] + nums[res[1]] == target) {
                return res;
            }
            
            int temp = map.get(Integer.valueOf(target - nums[res[0]])) == null 
                    ? Integer.MAX_VALUE
                    : map.get(Integer.valueOf(target - nums[res[0]]));
            if (temp != Integer.MAX_VALUE) {
                res[1] = temp;
                if (res[0] != res[1])
                    break;
            }
        }

        return res;
    }
}