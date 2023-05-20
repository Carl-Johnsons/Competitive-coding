
public class Word_Search {
    static StringBuilder tempString = new StringBuilder();

    public static void main(String[] args) {
        char[][] board = {
                { 'C', 'A', 'H' },
                { 'A', 'A', 'A' },
                { 'B', 'C', 'D' }
        };
        String word = "AAB";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        if (m * n == 1 && word.equals(String.valueOf(board[0][0])))
            return true;

        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backTracking(board, word.toCharArray(), i, j, new StringBuilder(board[0][0]), visited))
                    return true;
            }
        }
        return false;
    }

    public static boolean backTracking(
            char[][] board,
            char[] word,
            int row,
            int col,
            StringBuilder tempString,
            boolean[][] visited) {

        // Base case to break the backtracking
        if (row == board.length && col == board[0].length)
            return false;
        if (visited[row][col] || board[row][col] != word[tempString.length()])
            return false;
        if (tempString.toString().length() == word.length)
            return true;

        tempString.append(board[row][col]);
        visited[row][col] = true;
        // Base case to break the backtracking
        if (tempString.toString().length() == word.length)
            return true;
        for (int k = -1; k <= 1; k += 2) {
            if (row + k >= 0
                    && row + k < board.length
                    && !visited[row + k][col]
                    && board[row + k][col] == word[tempString.length()]) {
                if (backTracking(board, word, row + k, col, tempString, visited))
                    return true;
            }
            if (col + k >= 0
                    && col + k < board[row].length
                    && !visited[row][col + k]
                    && board[row][col + k] == word[tempString.length()]) {
                if (backTracking(board, word, row, col + k, tempString, visited))
                    return true;
            }
        }
        tempString.deleteCharAt(tempString.length() - 1);
        visited[row][col] = false;
        return false;
    }
}
