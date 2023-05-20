import java.util.Arrays;

public class Sudoku_Solver {
    static int count = 0;

    public static void main(String[] args) {
        char board[][] = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("Take " + count + " times to explore");
    }

    public static void solveSudoku(char[][] board) {
        backTracking(board, 0, 0);
    }

    public static boolean backTracking(
            char[][] board,
            int startRow,
            int startCol) {
        // System.out.println("Current pos:[" + startRow + ", " + startCol + "]");
        // for (int i = 0; i < board.length; i++) {
        // System.out.println(Arrays.toString(board[i]));
        // }
        // System.out.println("-------------------------------------------------");

        int a = startRow, b = startCol;
        boolean IsSolved = true;
        for (; a < board.length; a++) {
            while (b < board.length) {
                if (board[a][b] == '.') {
                    startRow = a;
                    startCol = b;
                    break;
                }
                b++;
            }
            b = 0;
            if (board[startRow][startCol] == '.') {
                IsSolved = false;
                break;
            }
        }
        if (IsSolved) {
            return true;
        }

        for (char k = '1'; k <= '9'; k++) {
            if (!isSafe(board, startRow, startCol, k)) {
                continue;
            }
            count++;
            board[startRow][startCol] = k;
            if (backTracking(board, startRow, startCol)) {
                return true;
            }
            board[startRow][startCol] = '.';
        }
        return false;
    }

    public static boolean isSafe(
            char board[][], int row, int col, char value) {
        return notInRow(board, row, col, value)
                && notInCol(board, row, col, value)
                && notInBox(board, row - row % 3, col - col % 3, row, col, value);
    }

    public static boolean notInRow(char[][] board, int row, int col, char value) {
        for (int i = 0; i < board.length; i++) {
            if (i == col)
                continue;
            if (board[row][i] == value)
                return false;
        }
        return true;
    }

    public static boolean notInCol(char[][] board, int row, int col, char value) {
        for (int i = 0; i < board.length; i++) {
            if (i == row)
                continue;
            if (board[i][col] == value)
                return false;
        }
        return true;
    }

    public static boolean notInBox(char[][] board, int startRow, int startCol, int row, int col, char value) {
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (i == col && i == row)
                    continue;
                if (board[i][j] == value)
                    return false;
            }
        }
        return true;
    }
}