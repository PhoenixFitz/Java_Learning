package stage.one.klaus;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutations {

    public static void main(String[] args){

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums);
        return result;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums){
        if(temp.size() == nums.length)
            list.add(new ArrayList<Integer>(temp));
        else{
            for(int i = 0; i < nums.length; i++){
                if(temp.contains(nums[i]))   // element already exists, skip
                    continue;
                temp.add(nums[i]);
                backtrack(list, temp, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
