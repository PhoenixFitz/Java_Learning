package stage.one.klaus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Permutations02 {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,1,1,2};

        for(List<Integer> list : permuteUnique(nums))
        System.out.println(list);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);  //排序
        List<Integer> l1 = new ArrayList<>();
        backtrack(list, l1, nums, new boolean[nums.length]);
        return list;
    }
    //boolean[]  存储元素是否已使用的标记
    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                //判断该位置元素是否已经在链表中，或判断该位置元素与之前元素的值是否相等
                if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
                used[i] = true;   //将i位置的存储标记置为true ， 放入存储链表
                tempList.add(nums[i]);
                System.out.println(Arrays.toString(used));
                backtrack(list, tempList, nums, used);
                used[i] = false; // 递归结束后， 将i位置的存储标记置为false ， 移出存储链表
                tempList.remove(tempList.size() - 1);


            }
        }
    }
}
