package stage.two.klaus;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    //dynamic programming
    //维护一个一位数组dp，其中dp[i]表示到i位置时不相邻数能形成的最大和，那么状态转移方程怎么写呢，我们先拿一个简单的例子来分析一下，
    // 比如说nums为{3, 2, 1, 5}，那么我们来看我们的dp数组应该是什么样的，首先dp[0]=3没啥疑问，再看dp[1]是多少呢，由于3比2大，
    // 所以我们抢第一个房子的3，当前房子的2不抢，所以dp[1]=3，那么再来看dp[2]，由于不能抢相邻的，所以我们可以用再前面的一个的dp值加上当前的房间值，
    // 和当前房间的前面一个dp值比较，取较大值当做当前dp值，所以我们可以得到状态转移方程dp[i] = max(num[i] + dp[i - 2], dp[i - 1]),
    // 由此看出我们需要初始化dp[0]和dp[1]，其中dp[0]即为num[0]，dp[1]此时应该为max(num[0], num[1])，
    public int rob(int[] nums){
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[nums.length - 1];

    }
    //分别维护两个变量robEven和robOdd，顾名思义，robEven就是要抢偶数位置的房子，robOdd就是要抢奇数位置的房子。所以我们在遍历房子数组时，
    // 如果是偶数位置，那么robEven就要加上当前数字，然后和robOdd比较，取较大的来更新robEven。这里我们就看出来了，robEven组成的值并不是只由偶数位置的数字，
    // 只是当前要抢偶数位置而已。同理，当奇数位置时，robOdd加上当前数字和robEven比较，取较大值来更新robOdd，这种按奇偶分别来更新的方法，
    // 可以保证组成最大和的数字不相邻，最后别忘了在robEven和robOdd种取较大值返回，
    public int rob02(int[] nums){
        int robEven = 0, robOdd = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0)
                robEven = Math.max(robEven + nums[i], robOdd);
            else
                robOdd = Math.max(robOdd + nums[i], robEven);
        }
        return Math.max(robEven, robOdd);
    }
}
