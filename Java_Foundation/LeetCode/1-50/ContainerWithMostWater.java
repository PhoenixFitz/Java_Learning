package stage.one.klaus;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {

    public static void main(String[] args){
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(nums));
        System.out.println(maxArea02(nums));

    }

    // brute force
    public static int maxArea(int[] height){
        if(height.length < 2)
            return 0;
        int maxWater = 0;
        for(int i = 0; i < height.length; i++){
            for (int j = i + 1; j  < height.length; j++){
                maxWater = Math.max(maxWater, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return maxWater;
    }

    //two pointer approach
    /**
     * We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines.
     * Futher, we maintain a variable maxareamaxarea to store the maximum area obtained till now. At every step,
     * we find out the area formed between them, update maxareamaxarea and move the pointer pointing to the shorter line towards the other end by one step.
     */

    public static int maxArea02(int[] height){
        if (height.length < 2)
            return 0;
        int i = 0;    //数组开头
        int j = height.length - 1;   //数组的尾端
        int maxWater = 0;
        while(i < j){
            maxWater = Math.max(maxWater, (j - i) * Math.min(height[i], height[j]));
            if(height[i] < height[j]){   // 值更小的索引移动
                i++;
            }else{
                j--;
            }
        }
        return maxWater;
    }





}
