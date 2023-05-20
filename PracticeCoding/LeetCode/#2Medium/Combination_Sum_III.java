import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination_Sum_III {
    public static void main(String[] args) {
        int k = 2;
        int n = 9;
        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new LinkedList<>();
        int sumUniqueNum = k * (k + 1) / 2;
        if (n >= sumUniqueNum) {
            backTracking(list, new ArrayList<>(), n, k, 1);
        }
        return list;
    }

    public static void backTracking(
            List<List<Integer>> list,
            List<Integer> tempList,
            int target,
            int k,
            int start) {
        if (k == 0 && target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (target < 0 || k < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > target) {
                continue;
            }
            tempList.add(i);
            backTracking(list, tempList, target - i, k - 1, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
