public class Matrix_Diagonal_Sum {
    public static void main(String[] args) {
        int mat[][] = {
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 }
        };
        System.out.println(diagonalSum(mat));
    }

    public static int diagonalSum(int[][] mat) {
        int n = mat.length, sum = 0;
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (mat[i][i] >= 0) {
                sum += mat[i][i];
                mat[i][i] = -mat[i][i];
            }
            if (mat[i][j] >= 0) {
                sum += mat[i][j];
                mat[i][j] = -mat[i][j];
            }

        }
        return sum;
    }
}