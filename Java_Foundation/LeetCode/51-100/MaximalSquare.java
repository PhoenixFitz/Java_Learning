package stage.two.klaus;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {

    //brute force
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows != 0 ? matrix[0].length : 0;
        int maxSide= 0;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(matrix[i][j] == '1'){
                    int side = 1;
                    boolean flag = true;  //正方形标记
                    while(i + side < rows && j + side < cols && flag){
                        for(int k = i; k <= i + side; k++){
                            if(matrix[k][j + side] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        for(int k = j; k <= j+ side; k++){
                            if(matrix[i + side][k] == '0'){
                                flag = false;
                                break;
                            }
                        }
                        if(flag)
                            side++;
                    }
                    if(side > maxSide)
                        maxSide = side;
                }

            }
        }
        return maxSide * maxSide;
    }


    //dynamic programming
    /**
     * 使用 DP，建立一个二维 dp 数组，其中 dp[i][j] 表示到达 (i, j) 位置所能组成的最大正方形的边长。
     * 我们首先来考虑边界情况，也就是当i或j为0的情况，那么在首行或者首列中，必定有一个方向长度为1，那么就无法组成长度超过1的正方形，
     * 最多能组成长度为1的正方形，条件是当前位置为1。边界条件处理完了，再来看一般情况的递推公式怎么办，对于任意一点 dp[i][j]，
     * 由于该点是正方形的右下角，所以该点的右边，下边，右下边都不用考虑，关心的就是左边，上边，和左上边。这三个位置的dp值 suppose 都应该算好的，
     * 还有就是要知道一点，只有当前 (i, j) 位置为1，dp[i][j] 才有可能大于0，否则 dp[i][j] 一定为0。当 (i, j) 位置为1，
     * 此时要看 dp[i-1][j-1], dp[i][j-1]，和 dp[i-1][j] 这三个位置，我们找其中最小的值，并加上1，就是 dp[i][j] 的当前值了，
     * 这个并不难想，毕竟不能有0存在，所以只能取交集，最后再用 dp[i][j] 的值来更新结果 res 的值即可
     */

    public int maximalSquare02(char[][] matrix){
        int rows = matrix.length;
        int cols = rows != 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows][cols];
        int res = 0;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j] - '0';   //强制转换
                }else if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;

    }


}
