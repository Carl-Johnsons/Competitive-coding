
public class Island_Perimeter {
    public static void main(String[] args) {
        int grid[][] = {
                { 1, 1, 1 },
                { 1, 0, 0 }
        };
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int i = 0, j = 0;
        int perimeter = 0;
        for (; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                perimeter += 4;
                for (int k = -1; k <= 1; k += 2) {
                    if (i + k >= 0 && i + k < grid.length &&
                            grid[i + k][j] == 1) {
                        perimeter--;
                    }
                }
                for (int l = -1; l <= 1; l += 2) {
                    if (j + l >= 0 && j + l < grid[0].length &&
                            grid[i][j + l] == 1) {
                        perimeter--;
                    }
                }

            }
        }

        return perimeter;
    }

    public static int bfs(
            int grid[][], int i, int j, boolean[][] visited) {
        if (i < 0
                || i >= grid.length
                || j < 0
                || j >= grid[0].length
                || grid[i][j] == 0)
            return 1;

        if (visited[i][j] && grid[i][j] == 1)
            return 0;

        visited[i][j] = true;

        return bfs(grid, i + 1, j, visited)
                + bfs(grid, i - 1, j, visited)
                + bfs(grid, i, j + 1, visited)
                + bfs(grid, i, j - 1, visited);
    }

}
