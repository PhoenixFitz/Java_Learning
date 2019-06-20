package stage.two.klaus;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    //用两个指针,一起往后扫，i指针每次循环+1，值不等于0时，num[i] 和 num[j]交换，j指针+1
    public void moveZeroes(int[] nums) {
        if (nums.length == 0)
            return;
        for(int i = 0, j = 0; i < nums.length; i++){
            if(nums[i] != 0){
                swap(nums, i, j);
                j++;
            }
        }

    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
