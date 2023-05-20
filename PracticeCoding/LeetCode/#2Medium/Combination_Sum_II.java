import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Combination_Sum_II {
    public static void main(String[] args) {
        int arr[] = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        System.out.println(combinationSum2(arr, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(list, new ArrayList<>(), 0, candidates, target);

        return list;
    }

    public static void backtracking(
            List<List<Integer>> list,
            List<Integer> combination,
            int i,
            int[] candidates,
            int remain) {

        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            list.add(new LinkedList<>(combination));
        } else {
            for (int j = i; j < candidates.length; j++) {
                if (j > i && candidates[j] == candidates[j - 1]) {
                    continue;
                }
                if (candidates[i] > remain) {
                    break;
                }
                combination.add(candidates[j]);
                backtracking(list, combination, j + 1, candidates, remain - candidates[j]);
                combination.remove(combination.size() - 1);

            }
        }

    }
}
