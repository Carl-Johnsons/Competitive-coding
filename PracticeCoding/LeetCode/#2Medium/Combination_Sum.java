import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination_Sum {
    public static void main(String[] args) {
        int arr[] = { 2, 3, 6, 7, 11, 13, 15 };
        int target = 15;
        System.out.println(combinationSum(arr, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new LinkedList<>();
        backTracking(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public static void backTracking(
            List<List<Integer>> list,
            List<Integer> tempList,
            int[] candidates,
            int target,
            int start) {
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target)
                continue;
            tempList.add(candidates[i]);
            backTracking(list, tempList, candidates, target - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }

}
