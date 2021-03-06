package stage.one.klaus;

/**
 *A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 */
public class UniquePaths {

    public static void main(String[] args){
        int res = uniquePaths(7, 3);
        System.out.println(res);
    }

    /**
     * The assumptions are
     *
     * When (n==0||m==0) the function always returns 1 since the robot
     * can't go left or up.
     * For all other cells. The result = uniquePaths(m-1,n)+uniquePaths(m,n-1)
     * Therefore I populated the edges with 1 first and use DP to get the full 2-D array.
     */
    public static int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        for(int i = 0; i < m; i++)
            map[i][0] = 1;
        for(int i = 0; i < n; i++)
            map[0][i] = 1;
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++){
                map[i][j] = map[i - 1][j] + map[i][j - 1];
            }
        return map[m - 1][n - 1];
    }
}
