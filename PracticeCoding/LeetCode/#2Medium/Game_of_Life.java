import java.util.Arrays;

public class Game_of_Life {
    public static void main(String[] args) {
        int[][] board = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };
        gameOfLife(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void gameOfLife(int[][] board) {
        // 2 mean 1, 3 mean 0
        /*
         * Any live cell with < 2 live neighbors dies as if caused by
         * under-population.
         * 
         * Any live cell = 2 or 3 live neighbors lives on to the next
         * generation.
         * 
         * Any live cell with > 3 live neighbors dies, as if by
         * over-population.
         * 
         * Any dead cell = 3 live neighbors becomes a live cell, as if by
         * reproduction.
         */
        int neighbors = 0;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2 || board[i][j] == 3)
                    continue;

                neighbors = check(board, i, j, m, n);

                if (board[i][j] == 0 && neighbors == 3) {
                    board[i][j] = 2;
                } else if ((board[i][j] == 1) && (neighbors < 2 || neighbors > 3)) {
                    board[i][j] = 3;
                }
                // System.out.println("row :" + i + " | " + "col :" + j);
                // for (int a = 0; a < board.length; a++) {
                // System.out.println(Arrays.toString(board[a]));
                // }
                // System.out.println();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = (board[i][j] == 3 || board[i][j] == 0 ? 0 : 1);
            }
        }
    }

    public static int check(int[][] board, int row, int col, int m, int n) {
        int count = 0, newRow, newCol;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;
                newRow = row + i;
                newCol = col + j;
                if (newRow < m
                        && newRow >= 0
                        && newCol < n
                        && newCol >= 0
                        && (board[newRow][newCol] == 1 || board[newRow][newCol] == 3)) {

                    count++;
                }
            }
        }
        return count;
    }
}
