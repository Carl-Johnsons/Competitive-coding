import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        System.out.println(subsets(arr));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        backTracking(list, new ArrayList<>(), nums, 0);

        return list;
    }

    public static void backTracking(
            List<List<Integer>> list,
            List<Integer> tempList,
            int[] nums,
            int start) {

        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTracking(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
