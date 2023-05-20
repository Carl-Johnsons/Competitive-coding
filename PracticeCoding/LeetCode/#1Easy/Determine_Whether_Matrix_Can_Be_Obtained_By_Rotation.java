public class Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {
    public static void main(String[] args) {
        int arr[][] = {
                { 0, 1 },
                { 1, 0 }
        };
        int target[][] = {
                { 1, 0 },
                { 0, 1 }
        };
        System.out.println(findRotation(arr, target));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        // Transpose the matrix
        int n = mat.length, temp, count = 0, low, high;
        while (count < 4) {
            for (int row = 0; row < n; row++) {
                for (int col = row + 1; col < n; col++) {
                    temp = mat[row][col];
                    mat[row][col] = mat[col][row];
                    mat[col][row] = temp;
                }
            }
            low = 0;
            high = n - 1;
            while (low < high) {
                for (int row = 0; row < n; row++) {
                    temp = mat[row][low];
                    mat[row][low] = mat[row][high];
                    mat[row][high] = temp;
                }
                low++;
                high--;
            }
            if (check(mat, target))
                return true;
            count++;
        }

        return false;
    }

    public static boolean check(int[][] mat, int[][] target) {
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j])
                    return false;
            }
        }
        return true;
    }

}
