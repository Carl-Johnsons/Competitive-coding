import java.util.Arrays;

public class Surrounded_Regions {

    public static void main(String[] args) {
        char[][] board = {
                { 'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'O' },
                { 'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
                { 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'O' },
                { 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X' },
                { 'X', 'X', 'O', 'X', 'X', 'O', 'O', 'X', 'X', 'X' },
                { 'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O' },
                { 'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O' },
                { 'X', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O' }
        };
        solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O')
                dfsFlag(board, 0, i);
            if (board[m - 1][i] == 'O')
                dfsFlag(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfsFlag(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfsFlag(board, i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X')
                    continue;

                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfsFlag(
            char[][] board,
            int i,
            int j) {
        if (i < 0
                || j < 0
                || i >= board.length
                || j >= board[0].length)
            return;
        if (board[i][j] == 'X' || board[i][j] == '#')
            return;
        board[i][j] = '#';

        dfsFlag(board, i + 1, j);
        dfsFlag(board, i - 1, j);
        dfsFlag(board, i, j + 1);
        dfsFlag(board, i, j - 1);
    }

    static void printArray(char arr[][], int x, int y) {
        System.out.println("Start: [" + x + ", " + y + "]");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
