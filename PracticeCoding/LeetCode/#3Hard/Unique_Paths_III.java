// import java.util.ArrayList;
// import java.util.List;

public class Unique_Paths_III {
    public static void main(String[] args) {
        int grid[][] = {
                { 1, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 2 }
        };
        System.out.println(uniquePathsIII(grid));
    }

    // public static int uniquePathsIII(int[][] grid) {
    // int paths = 0;
    // int emptyCells = 0;
    // int startCellx = -1, startCelly = -1;

    // for (int i = 0; i < grid.length; i++) {
    // for (int j = 0; j < grid[0].length; j++) {
    // emptyCells += (grid[i][j] == 0 || grid[i][j] == 1 ? 1 : 0);
    // if (grid[i][j] == 1) {
    // startCellx = i;
    // startCelly = j;
    // }
    // }
    // }
    // List<List<Node>> list = new ArrayList<>();
    // backTracking(list, new ArrayList<>(), grid, emptyCells, startCellx,
    // startCelly);
    // for (int i = 0; i < list.size(); i++) {
    // System.out.print("[");
    // for (int j = 0; j < list.get(i).size(); j++) {
    // System.out.print("(" + list.get(i).get(j).x + ", " + list.get(i).get(j).y +
    // "), ");
    // }
    // System.out.println("]");
    // }
    // return paths;
    // }

    // public static void backTracking(
    // List<List<Node>> list,
    // List<Node> tempList,
    // int[][] grid,
    // int emptyCells,
    // int i,
    // int j) {
    // if (i < 0 || j < 0 || j >= grid[0].length || i >= grid.length) {
    // return;
    // }

    // if (grid[i][j] == Integer.MAX_VALUE || grid[i][j] == -1)
    // return;

    // if (emptyCells == 0 && grid[i][j] == 2) {
    // tempList.add(new Node(i, j));
    // list.add(new ArrayList<>(tempList));
    // tempList.remove(tempList.size() - 1);
    // return;
    // }
    // if (grid[i][j] == 2)
    // return;

    // int oldValue = grid[i][j];
    // tempList.add(new Node(i, j));
    // grid[i][j] = Integer.MAX_VALUE;
    // backTracking(list, tempList, grid, emptyCells - 1, i + 1, j);
    // backTracking(list, tempList, grid, emptyCells - 1, i - 1, j);
    // backTracking(list, tempList, grid, emptyCells - 1, i, j + 1);
    // backTracking(list, tempList, grid, emptyCells - 1, i, j - 1);
    // grid[i][j] = oldValue;
    // tempList.remove(tempList.size() - 1);
    // }

    // static class Node {
    // int x;
    // int y;

    // Node(int x, int y) {
    // this.x = x;
    // this.y = y;
    // }
    // }

    static int paths = 0;

    public static int uniquePathsIII(int[][] grid) {
        int emptyCells = 0;
        int startCellx = -1, startCelly = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                emptyCells += (grid[i][j] == 0 || grid[i][j] == 1 ? 1 : 0);
                if (grid[i][j] == 1) {
                    startCellx = i;
                    startCelly = j;
                }
            }
        }
        backTracking(grid, emptyCells, startCellx, startCelly);

        return paths;
    }

    public static void backTracking(
            int[][] grid,
            int emptyCells,
            int i,
            int j) {
        if (i < 0
                || j < 0
                || j >= grid[0].length || i >= grid.length
                || grid[i][j] == Integer.MAX_VALUE
                || grid[i][j] == -1) {
            return;
        }

        if (emptyCells == 0 && grid[i][j] == 2) {
            paths++;
            return;
        }
        if (grid[i][j] == 2)
            return;

        int oldValue = grid[i][j];
        grid[i][j] = Integer.MAX_VALUE;
        backTracking(grid, emptyCells - 1, i + 1, j);
        backTracking(grid, emptyCells - 1, i - 1, j);
        backTracking(grid, emptyCells - 1, i, j + 1);
        backTracking(grid, emptyCells - 1, i, j - 1);
        grid[i][j] = oldValue;
    }

}
