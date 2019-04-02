package stage.one.klaus;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 */
public class TrappingRainWater {
    public static void main(String[] args){

    }


/**
 * Dynamic Programming
 * Algorithm:
 * Find maximum height of bar from the left end upto an index i in the array \text{left\_max}left_max.
 * Find maximum height of bar from the right end upto an index i in the array \text{right\_max}right_max.
 * Iterate over the \text{height}height array and update ans:
 *      Add min(max_left[i],max_right[i]) - height[i] to ans
 */
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        int ans = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        for(int i = 1; i < height.length; i++){
            left[i] = Math.max(height[i],left[i - 1]);
        }
        right[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--){
            right[i] = Math.max(height[i], right[i+1]);
        }
        for(int i = 1; i < height.length -1;i ++){
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }


/**
 * 只需要遍历一次即可的解法
 * 这个算法需要left和right两个指针分别指向数组的首尾位置，从两边向中间扫描，在当前两指针确定的范围内，先比较两头找出较小值，
 * 如果较小值是left指向的值，则从左向右扫描，如果较小值是right指向的值，则从右向左扫描，若遇到的值比当较小值小，则将差值存入结果，
 * 如遇到的值大，则重新确定新的窗口范围，以此类推直至left和right指针重合，
 */
    public int trap02(int[] height) {

        int left = 0, right = height.length - 1,ans = 0;
        while(left < right){
            int mn = Math.min(height[left], height[right]);
            if(mn == height[left]){
                left++;
                while(left < right && height[left] < mn){
                    ans += mn - height[left];
                    left++;
                }
            }else{
                right--;
                while(left < right && height[right] < mn){
                    ans += mn - height[right];
                    right--;
                }
            }
        }
        return ans;
    }

}
