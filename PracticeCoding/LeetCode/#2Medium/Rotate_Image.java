import java.util.Arrays;

public class Rotate_Image {
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        rotate(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void rotate(int[][] matrix) {
        // Transpose the matrix
        int n = matrix.length;
        int temp;
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        // Swap the column
        int i = 0, j = n - 1;
        while (i < j) {
            for (int row = 0; row < n; row++) {
                temp = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = temp;
            }
            i++;
            j--;
        }
        System.gc();
    }
}
