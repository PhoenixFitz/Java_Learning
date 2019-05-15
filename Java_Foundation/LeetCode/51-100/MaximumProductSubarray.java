package stage.two.klaus;

/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {

    /**
     * 最直接的方法就是用DP来做，而且要用两个dp数组，其中f[i]表示子数组[0, i]范围内并且一定包含nums[i]数字的最大子数组乘积，
     * g[i]表示子数组[0, i]范围内并且一定包含nums[i]数字的最小子数组乘积，初始化时f[0]和g[0]都初始化为nums[0]，其余都初始化为0。
     * 那么从数组的第二个数字开始遍历，那么此时的最大值和最小值只会在这三个数字之间产生，即f[i-1]*nums[i]，g[i-1]*nums[i]，和nums[i]。
     * 所以我们用三者中的最大值来更新f[i]，用最小值来更新g[i]，然后用f[i]来更新结果res即可，由于最终的结果不一定会包括nums[n-1]这个数字，
     * 所以f[n-1]不一定是最终解，不断更新的结果res才是
     */
    public int maxProduct(int[] nums){
        int res = nums[0];
        int[] f = new int[nums.length], g = new int[nums.length];
        f[0] = nums[0]; //f[i]表示子数组[0, i]范围内并且一定包含nums[i]数字的最大子数组乘积
        g[0] = nums[0]; //g[i]表示子数组[0, i]范围内并且一定包含nums[i]数字的最小子数组乘积, 因为数组中有负数，所以需要计算每次的最小值
        for(int i = 1; i < nums.length; i++){
            f[i] = Math.max(Math.max(f[i - 1] * nums[i], nums[i]), g[i - 1] * nums[i]);
            g[i] = Math.min(Math.min(f[i - 1] * nums[i], nums[i]), g[i - 1] * nums[i]);
            res = Math.max(res, f[i]);
        }
        return res;
    }

    //更简洁的方法There we have a dynamic programming formula. Using two arrays of size n, we could deduce the final answer as f(n-1).
    // Since we only need to access its previous elements at each step, two variables are sufficient.
    // 这种方法也是用两个变量来表示当前最大值和最小值的，但是没有无脑比较三个数，而是对于当前的nums[i]值进行了正负情况的讨论
    // 这种方法的巧妙处在于先判断一个当前数字是否是负数，是的话就交换最大值和最小值。

    public int maxProduct02(int[] nums){
        int res = nums[0], max = nums[0], min = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
