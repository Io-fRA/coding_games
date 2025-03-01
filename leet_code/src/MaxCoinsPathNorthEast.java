import java.util.Arrays;

public class MaxCoinsPathNorthEast {

    public static int findMaxCoins(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // Initialize the first cell
        dp[0][0] = grid[0][0];

        // Initialize first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        // Initialize first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        // Fill the dp table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}
        };

        int maxCoins = findMaxCoins(grid);
        System.out.println("Maximum coins collected: " + maxCoins);
    }
}
