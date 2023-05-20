import java.util.Arrays;

public class Set_Matrix_Zeroes {

    public static void main(String[] args) {
        int matrix[][] = {
                { 0, 0, 0, 5 },
                { 4, 3, 1, 4 },
                { 0, 1, 1, 4 },
                { 1, 2, 1, 3 },
                { 0, 0, 1, 1 }
        };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Space Complexity O(m*n *2)
        // Time Complexity O(m*n*2)
        // int xArr[] = new int[m * n];
        // int yArr[] = new int[m * n];
        // int k = 0;
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // if (matrix[i][j] == 0) {
        // xArr[k] = i;
        // yArr[k] = j;
        // k++;
        // }
        // }
        // }
        // while (k-- != 0) {
        // for (int i = 0; i < m; i++) {
        // matrix[i][yArr[k]] = 0;
        // }
        // for (int i = 0; i < n; i++) {
        // matrix[xArr[k]][i] = 0;
        // }
        // }

        /* Space Complexity O(1) */
        int Inf = Integer.MAX_VALUE - 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] != 0)
                            matrix[k][j] = Inf;
                    }
                    for (int k = 0; k < n; k++) {
                        if (matrix[i][k] != 0)
                            matrix[i][k] = Inf;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Inf) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}