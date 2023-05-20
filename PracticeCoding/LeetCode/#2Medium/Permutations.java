import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        System.out.println(permute(arr));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int maxPermutation = 1;
        boolean visited[] = new boolean[nums.length];
        for (int i = 1; i <= nums.length; i++) {
            maxPermutation *= i;
        }
        backTracking(list, new ArrayList<>(), nums, maxPermutation, visited);
        return list;
    }

    public static void backTracking(
            List<List<Integer>> list,
            List<Integer> tempList,
            int nums[],
            int maxPermutation,
            boolean[] visited) {
        if (list.size() == maxPermutation) {
            return;
        }
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            tempList.add(nums[i]);
            visited[i] = true;
            backTracking(list, tempList, nums, maxPermutation, visited);
            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }
    }
}
