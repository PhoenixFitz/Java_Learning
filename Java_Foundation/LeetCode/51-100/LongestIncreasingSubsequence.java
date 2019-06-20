package stage.two.klaus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 */
public class LongestIncreasingSubsequence {

    //Dynamic Programming的解法，这种解法的时间复杂度为O(n2)，类似brute force的解法，我们维护一个一维dp数组，其中dp[i]表示以nums[i]为结尾的最长递增子串的长度，
    // 对于每一个nums[i]，我们从第一个数再搜索到i，如果发现某个数小于nums[i]，我们更新dp[i]，更新方法为dp[i] = max(dp[i], dp[j] + 1)，
    // 即比较当前dp[i]的值和那个小于num[i]的数的dp值加1的大小，我们就这样不断的更新dp数组，到最后dp数组中最大的值就是我们要返回的LIS的长度

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);     //若整个数列为降序， i等于任意值时，dp[i] = 1
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    //dp+二分查找法

    /**
     * In this approach, we scan the array from left to right. We also make use of a dpdp array initialized with all 0's. This dp array is meant
     * to store the increasing subsequence formed by including the currently encountered element. While traversing the numsnums array,
     * we keep on filling the dp array with the elements encountered so far. For the element corresponding to the j^{th} index (nums[j]),
     * we determine its correct position in the dpdp array(say i^{th} index) by making use of Binary Search(which can be used since the dp array
     * is storing increasing subsequence) and also insert it at the correct position. An important point to be noted is that for Binary Search,
     * we consider only that portion of the dp array in which we have made the updates by inserting some elements at their correct positions
     * (which remains always sorted). Thus, only the elements upto the i^{th} index in the dp array can determine the position of the current
     * element in it. Since, the element enters its correct position(i) in an ascending order in the dp array, the subsequence formed so far
     * in it is surely an increasing subsequence. Whenever this position index i becomes equal to the length of the LIS formed so far(len),
     * it means, we need to update the len as len = len + 1.
     *
     * Note: dp array does not result in longest increasing subsequence, but length of dp array will give you length of LIS.
     *
     * Consider the example:
     *
     * input: [0, 8, 4, 12, 2]
     *
     * dp: [0]
     *
     * dp: [0, 8]
     *
     * dp: [0, 4]
     *
     * dp: [0, 4, 12]
     *
     * dp: [0 , 2, 12] which is not the longest increasing subsequence, but length of dp array results in length of Longest Increasing Subsequence.
     * @param nums
     * @return
     */
    public int lengthOfLIS02(int[] nums){
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num : nums){
            int left = 0, right = len;
            while(left < right){
                int mid = (left + right) / 2;
                if(dp[mid] < num)
                    left = mid + 1;
                else
                    right = mid;
            }
            dp[right] = num;
            if(right == len)
                len++;

        }
        return len;
    }

}
