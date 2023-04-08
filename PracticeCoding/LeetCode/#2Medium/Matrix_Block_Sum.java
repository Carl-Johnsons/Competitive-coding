public class Matrix_Block_Sum {
    static int count = 0;

    public static void main(String[] args) {
        int arr[][] = {
                { 76, 4, 73 },
                { 21, 8, 56 },
                { 4, 56, 61 },
                { 70, 32, 38 },
                { 31, 94, 67 }
        };
        /*
         * [109,238,141],
         * [169,359,258],
         * [191,346,251],
         * [287,453,348],
         * [227,332,231]
         */

        // int arr[][] = {
        // { 1, 2, 3 },
        // { 4, 5, 6 },
        // { 7, 8, 9 }
        // };
        // [12,21,16],
        // [27,45,33],
        // [24,39,28]
        int arr2[][] = matrixBlockSum(arr, 1);
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(count);
    }

    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int afterSum[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                afterSum[i][j] = sumValue(mat, i, j, k, afterSum);
            }
        }
        return afterSum;
    }

    public static int sumValue(int arr[][], int x, int y, int k, int cache[][]) {
        int sum = 0;
        int m = arr.length;
        int n = arr[0].length;
        if (x == 0 && y == 0) {
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j <= k; j++) {
                    if (x + i < m && x + i >= 0 &&
                            y + j < n && y + j >= 0) {
                        sum += arr[x + i][y + j];
                    }
                    count++;
                }
            }
        } else {
            if (x != 0) {
                sum = cache[x - 1][y];
                for (int i = -k; i <= k; i++) {
                    if (y + i < n && y + i >= 0) {
                        if (x >= k + 1 && x - k - 1 >= 0) {
                            sum -= arr[x - k - 1][y + i];
                        }
                        if (x + k < m) {
                            sum += arr[x + k][y + i];
                        }
                        count++;
                    }
                }
            } else if (y != 0) {
                sum = cache[x][y - 1];
                for (int i = -k; i <= k; i++) {
                    if (x + i < m && x + i >= 0) {
                        if (y >= k + 1 && y - k - 1 >= 0) {
                            sum -= arr[x + i][y - k - 1];
                        }
                        if (y + k < n) {
                            sum += arr[x + i][y + k];
                        }
                        count++;
                    }
                }
            }
        }

        return sum;
    }
}
