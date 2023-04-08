
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Majority_Element_II {
    public static void main(String[] args) {
        int arr[] = { 1, 2 };
        System.out.println(majorityElement(arr));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new LinkedList<>();
        Map<Integer, Integer> occurences = new HashMap<>();
        int times_appear = nums.length / 3;
        for (int i = 0; i < nums.length; i++) {
            occurences.merge(nums[i], 1, Integer::sum);
            if (occurences.get(nums[i]) == times_appear + 1) {
                list.add(nums[i]);
            }
        }

        return list;

    }
}
