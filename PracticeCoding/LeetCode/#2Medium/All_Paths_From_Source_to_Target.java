import java.util.ArrayList;
import java.util.List;

public class All_Paths_From_Source_to_Target {
    public static void main(String[] args) {
        int arr[][] = {
                { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {}
        };
        System.out.println(allPathsSourceTarget(arr));

    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        tempList.add(0);
        backTracking(list, tempList, graph, 0);
        return list;
    }

    public static void backTracking(
            List<List<Integer>> list,
            List<Integer> tempList,
            int graph[][],
            int currentVertex) {
        if (currentVertex == graph.length - 1) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < graph[currentVertex].length; i++) {
            tempList.add(graph[currentVertex][i]);
            backTracking(list, tempList, graph, graph[currentVertex][i]);
            tempList.remove(tempList.size() - 1);
        }
    }
}
