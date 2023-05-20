import java.util.Arrays;

public class Spiral_Matrix_II {
    public static void main(String[] args) {
        Solution s = new Solution();
        int arr[][] = s.generateMatrix(6);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

}

class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int position = 1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[0][i] = position++;
        }

        int count = n;
        int i = 1, j = n - 1;
        int turn = 1;
        while (count-- != 0) {

            for (int k = 0; k < count; k++) {
                matrix[i][j] = position++;
                i += turn;
                i -= (1 - turn);
            }

            i -= turn;
            j -= turn;
            i += (1 - turn);
            j += (1 - turn);

            for (int k = 0; k < count; k++) {
                matrix[i][j] = position++;
                j -= turn;
                j += (1 - turn);
            }

            i -= turn;
            j += turn;
            i += (1 - turn);
            j -= (1 - turn);
            turn = 1 - turn;
        }

        return matrix;
    }
}