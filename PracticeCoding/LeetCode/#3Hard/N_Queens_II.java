import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens_II {
    public static void main(String[] args) {
        // List<List<String>> list = solveNQueens(1);

        // for (int i = 0; i < list.size(); i++) {
        // System.out.println(list.get(i));
        // }
        // System.out.println("There are " + list.size() + " solutions");
        long now = System.currentTimeMillis();
        System.out.println(totalNQueens(13));
        System.out.println("Time solving: " + (System.currentTimeMillis() - now) + "ms");
        // 4, 2
        // 5, 10
        // 6, 4
        // 7, 40
        // 8, 92
        // 9, 352
        // 10, 724
        // 11, 2680
        // 12, 14200
    }

    public static int totalNQueens(int n) {
        return solveNQueens(n).size();
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<char[]>> list = new ArrayList<>();
        char[] charArray = new char[n];
        // Initialize the array
        Arrays.fill(charArray, '.');
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>(n));
            list.get(i).add(charArray.clone());
        }
        boolean[] occupiedHorizontal = new boolean[n];
        boolean[] occupiedVertical = new boolean[n];
        boolean main_diagonal[] = new boolean[n * 2];
        boolean auxiliary_diagonal[] = new boolean[n * 2];

        List<List<String>> result = new ArrayList<>();
        backTracking(list, 0, occupiedHorizontal, occupiedVertical, main_diagonal, auxiliary_diagonal, result);

        return result;
    }

    public static boolean backTracking(
            List<List<char[]>> list,
            int i,
            boolean[] occupiedHorizontal,
            boolean[] occupiedVertical,
            boolean main_diagonal[],
            boolean auxiliary_diagonal[],
            List<List<String>> ans) {
        if (i >= list.size()) {
            ans.add(new ArrayList<>(list.size()));
            for (int k = 0; k < list.size(); k++) {
                ans.get(ans.size() - 1).add(new String(list.get(k).get(0)));
            }
        }
        if (i == list.size()) {
            return false;
        }
        for (int j = 0; j < list.size(); j++) {
            if (!occupiedHorizontal[i]
                    && !occupiedVertical[j]
                    && !main_diagonal[i + j]
                    && !auxiliary_diagonal[i - j + list.size() - 1]) {
                // Explore
                list.get(i).get(0)[j] = 'Q';
                occupiedHorizontal[i] = true;
                occupiedVertical[j] = true;
                main_diagonal[i + j] = true;
                auxiliary_diagonal[i - j + list.size() - 1] = true;
                
                // Check
                if (backTracking(
                        list,
                        i + 1,
                        occupiedHorizontal,
                        occupiedVertical,
                        main_diagonal,
                        auxiliary_diagonal,
                        ans)) {
                    return true;
                }

                // Backtrack
                occupiedHorizontal[i] = false;
                occupiedVertical[j] = false;
                main_diagonal[i + j] = false;
                auxiliary_diagonal[i - j + list.size() - 1] = false;
                list.get(i).get(0)[j] = '.';
            }
        }

        return false;
    }

}
