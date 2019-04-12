package stage.one.klaus;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {
    public static void main(String[] args){
        int[] tests = new int[]{1,2,3};
        System.out.println(subsets(tests));
    }

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    //回溯法
    public static void backTrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int start){
        list.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; i++){
            temp.add(nums[i]);
            backTrack(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);

        }
    }
}
