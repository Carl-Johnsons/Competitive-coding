public class Valid_Sudoku {
    public static void main(String[] args) {
        char board[][] = {
                { '8', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        char value;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                value = board[i][j];
                if (value == '.') {
                    continue;
                }
                if (!(notInRow(board, i, j)
                        && notInCol(board, i, j)
                        && notInBox(board, i - i % 3, j - j % 3, i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean notInRow(char board[][], int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == '.')
                continue;
            if (i != col && board[row][i] == board[row][col])
                return false;
        }
        return true;
    }

    public static boolean notInCol(char board[][], int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == '.')
                continue;
            if (i != row && board[i][col] == board[row][col])
                return false;
        }
        return true;
    }

    public static boolean notInBox(char board[][], int startRow, int startCol, int row, int col) {
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == '.')
                    continue;
                if (i != row && j != col && board[i][j] == board[row][col])
                    return false;
            }
        }
        return true;
    }
}
