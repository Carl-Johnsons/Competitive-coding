import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(combine(1, 1));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backTracking(list, new ArrayList<>(), n, k, 1);
        return list;
    }

    public static void backTracking(
            List<List<Integer>> list,
            List<Integer> tempList,
            int n,
            int k,
            int start) {
        if (k == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        if (k < 0) {
            return;
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backTracking(list, tempList, n, k - 1, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
