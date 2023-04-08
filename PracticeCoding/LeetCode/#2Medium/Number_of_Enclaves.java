import java.util.Stack;

public class Number_of_Enclaves {
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 1, 1, 0 },
                { 1, 0, 0, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };


        System.out.println(numEnclaves(arr));
    }

    public static int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Cell current;
        int count = 0;
        // Count all 1's
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }

        while ((current = hasBoundary(grid)) != null) {
            count -= dfs(grid, current.row, current.col);
        }

        return count;
    }

    public static Cell hasBoundary(int arr[][]) {
        int m = arr.length;
        int n = arr[0].length;
        // Row
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 1) {
                return new Cell(i, 0);
            }
            if (arr[i][n - 1] == 1) {
                return new Cell(i, n - 1);
            }
        }
        // Col
        for (int i = 0; i < n; i++) {
            if (arr[0][i] == 1) {
                return new Cell(0, i);
            }
            if (arr[m - 1][i] == 1) {
                return new Cell(m - 1, i);
            }
        }
        return null;
    }

    public static int dfs(int[][] arr, int x, int y) {
        Stack<Cell> stack = new Stack<>();
        Cell current = new Cell(x, y), temp;
        int value = 0;
        int count = 0;

        stack.push(current);
        // mark the location is 0 so we don't visit them anymore
        arr[current.row][current.col] = 0;

        while (!stack.isEmpty()) {
            current = stack.pop();

            while ((temp = current.next(arr, current.row, current.col)) != null) {
                value = arr[temp.row][temp.col];
                if (value != 0) {
                    stack.push(temp);
                    arr[temp.row][temp.col] = 0;
                }
            }
            count++;
        }
        return count;
    }

    static class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Cell next(int arr[][], int row, int col) {
            for (int i = -1; i <= 1; i += 2) {
                if (row + i >= 0 && row + i < arr.length && arr[row + i][col] == 1) {
                    return new Cell(row + i, col);
                }
            }
            for (int i = -1; i <= 1; i += 2) {
                if (col + i >= 0 && col + i < arr[0].length && arr[row][col + i] == 1) {
                    return new Cell(row, col + i);
                }
            }
            return null;
        }
    }
}
