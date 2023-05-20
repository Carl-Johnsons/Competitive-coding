import java.util.Arrays;

public class Unique_Paths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }


    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        for (int[] a : dp) {
            Arrays.fill(a, 1);
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
