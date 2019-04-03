package stage.one.klaus;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

    public boolean canJump01 (int[] nums) {
        if(nums[0] == 0 && nums.length > 1)
            return false;
        for(int i = 0; i < nums.length - 1; i++){  //循环到倒数第二个数字，看是否为0.
            if(i > 0 && nums[i] == 0){   //若某元素为0， 判断之前的数字的jump步数能否越过0所在的位置
                int j = i - 1;
                for(; j >= 0; j--){
                    if(nums[j] > i - j)
                        break;  //可以越过0所在位置，跳出循环
                }
                if(j == -1)  //0所在位置之前的所有元素都不能越过0所在的位置
                    return false;
            }
        }
        return true;
    }

    //Greedy Algorithm
    /**
     * 我们只希望知道能否到达末尾，也就是说我们只对最远能到达的位置感兴趣，所以我们维护一个变量reach，表示最远能到达的位置，初始化为0。
     * 遍历数组中每一个数字，如果当前坐标大于reach或者reach已经抵达最后一个位置则跳出循环，否则就更新reach的值为其和i + nums[i]中的较大值，
     * 其中i + nums[i]表示当前位置能到达的最大位置，
     */
    public boolean canJump02(int[] nums) {
        int reach = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > reach || reach >= nums.length - 1)
                break;
            reach = Math.max(reach, i + nums[i]);
        }
        return reach >= nums.length - 1;
    }

}
