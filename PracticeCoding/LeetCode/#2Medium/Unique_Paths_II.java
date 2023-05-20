
public class Unique_Paths_II {
    public static void main(String[] args) {
        int arr[][] = { { 0, 0, 0 },
                { 1, 0, 0 },
                { 0, 0, 0 } };
        System.out.println(uniquePathsWithObstacles(arr));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean rowHasObstacles[] = new boolean[m];
        boolean colHaveObstacles[] = new boolean[n];

        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1) {
                    rowHasObstacles[i] = true;
                    colHaveObstacles[j] = true;
                }
                if (rowHasObstacles[i] || colHaveObstacles[j])
                    continue;
                dp[i][j] = 1;
            }
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = (dp[row - 1][col] + dp[row][col - 1]) * (1 - obstacleGrid[row][col]);
            }
        }
        return dp[m - 1][n - 1];
    }

}
