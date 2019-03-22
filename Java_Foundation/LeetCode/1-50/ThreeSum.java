package leetcode.klaus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(nums);
        List<List<Integer>> ls  = threeSum(nums);

        for(List<Integer> l : ls){
            System.out.println(l);
        }
    }

    // The idea is:
    // (1) Sort the array - O(nlogn)
    // (2) Iterate the array - O(n)
    // (3) Find valid triplets - O(n)
    // Overall time complexity: O(n^2)
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        if(nums != null && nums.length > 2){
            Arrays.sort(nums); // Sort the original array
            for(int i = 0; i < nums.length - 2; i++){
                if(i > 0 && nums[i] == nums[i - 1]){ // Skip duplicated first number
                    continue;
                }
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum == 0){
                        lists.add(Arrays.asList(nums[i],nums[left], nums[right])); // static <T> List<T> asList​(T... a) 返回由指定数组支持的固定大小的列表。
                        while(left < right && nums[left] == nums[left + 1]){ // Skip duplicated second number
                            left++;
                        }
                        while(left < right && nums[right] == nums[right - 1]){ // Skip duplicated third number
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum < 0){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return lists;
    }
}
