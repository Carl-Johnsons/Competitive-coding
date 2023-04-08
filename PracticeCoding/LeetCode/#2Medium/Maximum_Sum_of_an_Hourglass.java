public class Maximum_Sum_of_an_Hourglass {
    public static void main(String[] args) {
        int arr[][] = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(maxSum(arr));
    }

    public static int maxSum(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        int sum;
        if (m * n < 9) {
            return max;
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                // Begin to sum
                sum = grid[i][j];
                for (int k = -1; k <= 1; k++) {
                    sum += grid[i - 1][j + k];
                }
                for (int k = -1; k <= 1; k++) {
                    sum += grid[i + 1][j + k];
                }
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }
}
