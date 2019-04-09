package stage.one.klaus;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {


    /**
     * 用动态规划Dynamic Programming来做，这应该算是DP问题中比较简单的一类，我们维护一个二维的dp数组，
     * 其中dp[i][j]表示当前位置的最小路径和，递推式也容易写出来 dp[i][j] = grid[i][j] + min(dp[i - 1][j], dp[i][j - 1]);
     *
     */
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < row; i++)
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        for(int i = 1; i < column; i++)
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        for(int i = 1; i < row; i++)
            for(int j = 1; j < column; j++)
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            return dp[row - 1][column - 1];
    }
}
