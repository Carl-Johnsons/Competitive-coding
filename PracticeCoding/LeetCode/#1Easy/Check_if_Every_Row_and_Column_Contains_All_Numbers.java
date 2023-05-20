public class Check_if_Every_Row_and_Column_Contains_All_Numbers {
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 1, 1 }, { 1, 2, 3 }, { 1, 2, 3 }
        };
        System.out.println(checkValid(arr));
    }

    public static boolean checkValid(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (!(notInRow(matrix, i, j) && notInCol(matrix, i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean notInRow(int[][] matrix, int row, int col) {
        int i = col;
        while (i < matrix.length - 1) {
            i++;
            if (matrix[row][i] == matrix[row][col])
                return false;
        }
        return true;
    }

    public static boolean notInCol(int[][] matrix, int row, int col) {
        int i = row;
        while (i < matrix.length - 1) {
            i++;
            if (matrix[i][col] == matrix[row][col])
                return false;
        }
        return true;
    }
}
