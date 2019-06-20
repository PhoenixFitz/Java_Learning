package stage.two.klaus;

/**
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {

    //dynamic programming
    /**
     * 我们维护一个一维动态数组dp，其中dp[i]表示钱数为i时的最小硬币数的找零，注意由于数组是从0开始的，所以我们要多申请一位，数组大小为amount+1，
     * 这样最终结果就可以保存在dp[amount]中了。初始化dp[0] = 0，因为目标值若为0时，就不需要硬币了。其他值可以初始化是amount+1，为啥呢，因为最小的硬币是1，
     * 所以amount最多需要amount个硬币，amount+1也就相当于当前的最大值了，注意这里不能用整型最大值来初始化，因为在后面的状态转移方程有加1的操作，有可能会溢出，
     * 除非你先减个1，这样还不如直接用amount+1舒服呢。好，接下来就是要找状态转移方程了，没思路？不要紧！回归例子1，假设我取了一个值为5的硬币，那么由于目标值是11，
     * 所以是不是假如我们知道dp[6]，那么就知道了组成11的dp值了？所以我们更新dp[i]的方法就是遍历每个硬币，如果遍历到的硬币值小于i值
     * （比如我们不能用值为5的硬币去更新dp[3]）时，我们用 dp[i - coins[j]] + 1 来更新dp[i]，所以状态转移方程为：
     *
     * dp[i] = min(dp[i], dp[i - coins[j]] + 1);
     * 其中coins[j]为第j个硬币，而i - coins[j]为钱数i减去其中一个硬币的值，剩余的钱数在dp数组中找到值，然后加1和当前dp数组中的值做比较，取较小的那个更新dp数组。
     */

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];  //dp[i]表示钱数为i时的最小硬币数的找零，注意由于数组是从0开始的
        for(int i = 1; i < dp.length; i++){  //数组初始化
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
