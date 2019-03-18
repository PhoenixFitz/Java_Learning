package stage.one.klaus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args){

        int[] nums = new int[]{2,5,7,8,11};
        int goal = 15;
        int[] result = twoSum02(nums,goal);
        System.out.println(Arrays.toString(result));   //输出数组元素  需要用到Arrays.toString();

    }

    //暴力解法
    public static int[] twoSum(int[] nums,int target){
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(target == nums[i] +nums[j]){
                    return new int[]{i,j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum02(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            int value = target - nums[i];
            if(map.containsKey(value)){
                return new int[]{map.get(value), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
