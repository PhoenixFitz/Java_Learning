package stage.one.klaus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */

public class CombinationSum {
    public static void main(String[] args){
        int[] nums = {2,3,6,7};
        List<List<Integer>> li = combinationSum(nums, 7);
        for(List<Integer> l : li)
            System.out.println(l);
    }

    public static  List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, target, 0);
        return result;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int remain, int start){
        if(remain < 0)
            return;
        else if(remain == 0)
            list.add(new ArrayList<>(temp));
        else{
            for(int i = start; i < nums.length; i++){
                temp.add(nums[i]);
                backtrack(list,temp,nums,remain - nums[i],i); // not i + 1 because we can reuse same elements
                temp.remove(temp.size() - 1); // 保证长度相同，内容不同
            }
        }
    }

}
