package stage.one.klaus;

import java.util.Arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

    public static void main(String[] args){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] res = maxSubArray(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] maxSubArray(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0, end = 0;
        for(int i = 0; i < nums.length ; i++){
            sum = Math.max(sum + nums[i],nums[i]);
            if(sum == nums[i])
                start = i;
            max = Math.max(max, sum);
            if(max == sum)
                end = i;
        }
        System.out.println("start:"+start+" end:"+end);
        int[] ans =Arrays.copyOfRange(nums, start,end+1);  // Arrays.copyOfRange 所包含的范围是[ , )
        return ans;
    }
}
