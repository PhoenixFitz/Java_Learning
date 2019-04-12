package stage.one.klaus;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * Example:
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */

public class LargestRectangleinHistogram {

    public static void main (String[] args){
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(largestRectangleArea02(nums));
    }
    /**
     * 遍历数组，每找到一个局部峰值（只要当前的数字大于后面的一个数字，那么当前数字就看作一个局部峰值，跟前面的数字大小无关），
     * 然后向前遍历所有的值，算出共同的矩形面积，每次对比保留最大值。这里再说下为啥要从局部峰值处理，看题目中的例子，局部峰值为2，6，3，
     * 我们只需在这些局部峰值出进行处理，为啥不用在非局部峰值处统计呢，这是因为非局部峰值处的情况，后面的局部峰值都可以包括，比如1和5，
     * 由于局部峰值6是高于1和5的，所有1和5能组成的矩形，到6这里都能组成，并且还可以加上6本身的一部分组成更大的矩形，
     * 那么就不用费力气去再统计一个1和5处能组成的矩形了。
     */

    public static int largestRectangleArea(int[] heights){
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            if(i + 1 < heights.length && heights[i] <= heights[i + 1])
                continue;
            int minHight = heights[i];
            for(int j = i; j >= 0; j--){
                minHight = Math.min(minHight, heights[j]);
                maxArea = Math.max(maxArea, minHight * (i - j + 1));
            }
        }
        return maxArea;
    }


    /**
     * 用递增栈来处理。
     * 遍历数组。当栈为空时，把元素的位置i入栈，
     * 栈不为空时，数组i位置的值若大于栈顶元素对应的数组值，入栈；否则出栈，并计算面积
     * 由于我们先取出栈中最高的板子，那么就可以先算出长度为1的矩形面积了，
     * 然后再取下一个板子，此时根据矮板子的高度算长度为2的矩形面积，以此类推，直到数值大于栈顶元素数值为止，再次进栈，
     */
    public static int largestRectangleArea02(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= heights.length; i++){
            int h = (i == heights.length ? 0 : heights[i]);  //判断数组是否越界
            if(stack.isEmpty() || heights[stack.peek()] <= h) //递增栈，数值值大于栈顶值，入栈
                stack.push(i);
            else{
                int cur = stack.pop();  //取出栈里最高的板子的位置，从该位置开始计算
                maxArea = Math.max(maxArea, heights[cur] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
                i--;
            }
        }
        return maxArea;
    }
}
