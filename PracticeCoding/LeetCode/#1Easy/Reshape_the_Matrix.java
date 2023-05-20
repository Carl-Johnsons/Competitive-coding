import java.util.Arrays;

public class Reshape_the_Matrix {
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2 },
                { 3, 4 }
        };
        System.out.println(Arrays.toString(matrixReshape(arr, 1, 4)));
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int newMatrix[][] = new int[r][c];

        int i, j, k = 0, l = 0;
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                newMatrix[k][l] = mat[i][j];
                l++;
                if (l == c) {
                    k++;
                    l = 0;
                }
            }
        }
        return newMatrix;
    }
}
