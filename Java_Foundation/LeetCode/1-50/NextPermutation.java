package stage.one.klaus;
/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

import java.util.Arrays;
//给定一组数字，
//降序序列是最大值， 升序序列是最小值。
public class NextPermutation {

    public static void main(String[] args){
        int[] test = {1,3,5,8,4,2,1};
        NextPermutation N = new NextPermutation();
        N.nextPermutation(test);
        System.out.println(Arrays.toString(test));
    }

    public void nextPermutation(int[] nums){
        if(nums.length <= 1 || nums == null)
            return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i+1]){   // Find 1st id i that breaks descending order
            i--;
        }
        if(i >= 0){  // If not entirely descending
            int j = nums.length - 1;  // Start from the end
            while(nums[i] >= nums[j])  // Find rightmost first larger id j
                j--;
            swap(nums, i, j);   // Switch i and j
        }
        reverse(nums, i+1); // Reverse the descending sequence

    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int i){
        int j = arr.length -1;
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
