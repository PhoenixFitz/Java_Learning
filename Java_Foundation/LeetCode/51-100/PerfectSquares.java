package stage.two.klaus;

import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

//四平方和定理说明每个正整数均可表示为4个整数的平方和。
public class PerfectSquares {

    //用动态规划 Dynamic Programming 来做，我们建立一个长度为 n+1 的一维dp数组，将第一个值初始化为0，其余值都初始化为 INT_MAX,
    //i从1循环到n，j每次从1开始，循环到 j*j <= i的位置。dp[i] 表示正整数i能少能由多个完全平方数组成
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i],dp[i - j * j] + 1 );
            }
        }
        return dp[n];
    }
}
