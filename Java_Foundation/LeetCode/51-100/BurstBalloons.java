package stage.two.klaus;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class BurstBalloons {


    //动态规划
    /**
     * https://www.cnblogs.com/grandyang/p/5006441.html
     * dp[i][k-1] 的意义是什么呢，是打爆区间 [i, k-1] 内所有的气球后的最大得分，此时第 k-1 个气球已经不能用了，同理，
     * 第 k+1 个气球也不能用了，相当于区间 [i, j] 中除了第k个气球，其他的已经爆了，那么周围的气球只能是第 i-1 个，和第 j+1 个了，
     * 所以得分应为 nums[i-1] * nums[k] * nums[j+1]，分析到这里，我们的状态转移方程应该已经跃然纸上了吧，如下所示：
     *
     * dp[i][j] = max(dp[i][j], nums[i - 1] * nums[k] * nums[j + 1] + dp[i][k - 1] + dp[k + 1][j])                 ( i ≤ k ≤ j )
     * 我们需要先更新完所有的小区间，然后才能去更新大区间
     */

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] new_nums = new int[n];
        for(int i = 0; i < nums.length; i++){
            new_nums[i + 1] = nums[i];
        }
        new_nums[0] = 1;
        new_nums[n - 1] = 1;

        int[][] dp = new int[n][n];

        for(int len = 1; len <= nums.length; len++){
            for(int i = 1; i <= nums.length - len + 1; i++) {
                int j = i + len - 1;
                for(int k = i; k <= j; k++){
                    dp[i][j] = Math.max(dp[i][j], new_nums[i - 1] * new_nums[k] * new_nums[j + 1] + dp[i][k - 1] + dp[k + 1][j]);
                }
            }
        }

        return dp[1][nums.length];
    }


    //dp  +  递归
    public int maxCoins02(int[] nums){
        int n = nums.length;
        int[] new_nums = new int[n + 2];
        for(int i = 0; i < n; i++){
            new_nums[i + 1] = nums[i];
        }
        new_nums[0] = 1;
        new_nums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return brust(new_nums, dp, 1, n);

    }

    public int brust(int[] nums, int[][] dp, int i, int j){
        if(i > j)
            return 0;
        if(dp[i][j] > 0)
            return dp[i][j];
        int res = 0;
        for(int k = i; k <= j; k++){
            res = Math.max(res,  nums[k] * nums[i - 1] * nums[j + 1] + brust(nums,dp, i, k - 1)+ brust(nums,dp, k + 1, j));
        }
        dp[i][j] = res;
        return res;

    }

}
