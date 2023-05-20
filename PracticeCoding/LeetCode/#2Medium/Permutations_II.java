import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations_II {
    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 3 };
        System.out.println(permuteUnique(arr));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        Set<List<Integer>> set = new LinkedHashSet<>();
        boolean[] visited = new boolean[nums.length];
        backTracking(set, new LinkedList<>(), nums, visited);
        for (List<Integer> uniqueList : set) {
            list.add(uniqueList);
        }
        return list;
    }

    public static void backTracking(
            Set<List<Integer>> set,
            List<Integer> tempList,
            int nums[],
            boolean visited[]) {
        if (tempList.size() == nums.length) {
            set.add(new LinkedList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            tempList.add(nums[i]);
            visited[i] = true;
            backTracking(set, tempList, nums, visited);
            tempList.remove(tempList.size() - 1);
            visited[i] = false;
        }

    }
}
