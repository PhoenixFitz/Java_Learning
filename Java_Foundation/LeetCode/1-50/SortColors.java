package stage.one.klaus;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
public class SortColors {

    //两步法
    /**
     * 首先遍历一遍原数组，分别记录0,1,2的个数
     * 然后更新原数组，按个数分别赋上0，1，2
     */

    public void sortColors(int[] nums){
        int[] count = new int[3];
        int index = 0;    //nums 索引
        for(int i = 0; i < nums.length; i++){
            count[nums[i]]++;
        }
        for(int i = 0; i < count.length; i++){ // 0，1，2
            for(int j = 0; j < count[i]; j++){ // 对nums每个元素按排列顺序重新赋值
                nums[index] = i;
                index++;
            }
        }
    }

    //一步法
    /**
     * 需要两个指针，一个头指针，一个尾指针
     * 定义red指针指向开头位置，blue指针指向末尾位置
     * 从头开始遍历原数组，如果遇到0，则交换该值和red指针指向的值，并将red指针后移一位。若遇到2，
     * 则交换该值和blue指针指向的值，并将blue指针前移一位。若遇到1，则继续遍历。
     * While curr <= p2 :
     * If nums[curr] = 0 : swap currth and red elements and move both pointers to the right.
     * If nums[curr] = 2 : swap currth and blue elements. Move pointer blue to the left.
     * If nums[curr] = 1 : move pointer curr to the right.
     */
    public void sortColors02(int[] nums){
        int red = 0, blue = nums.length - 1;
        int i = 0;
        while(i <= blue){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[red];
                nums[red] = temp;
                red ++;
                i++;
            }
            else if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[blue];
                nums[blue] = temp;
                blue--;
            }
            else
                i++;
        }
    }
}
