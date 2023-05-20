public class Number_of_Islands {
    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '1', '1' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0')
                    continue;
                bfs(grid, i, j);
                numIslands++;
            }
        }
        return numIslands;
    }

    public static void bfs(
            char[][] grid,
            int i,
            int j) {
        if (i < 0
                || j < 0
                || i >= grid.length
                || j >= grid[0].length)
            return;
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        bfs(grid, i + 1, j);
        bfs(grid, i - 1, j);
        bfs(grid, i, j - 1);
        bfs(grid, i, j + 1);
    }
}
