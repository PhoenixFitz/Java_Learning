package stage.two.klaus;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Note: Please solve it without division and in O(n).
 */
public class ProductofArrayExceptSelf {

    //brute force
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = 1;
            for(int j = 0; j < nums.length; j++){
                if(i == j)
                    continue;
                res[i] = res[i] * nums[j];
            }
        }

        return res;
    }


    //method 2

    /**
     * 这道题禁止我们使用除法，那么我们只能另辟蹊径。我们想，对于某一个数字，如果我们知道其前面所有数字的乘积，同时也知道后面所有的数乘积，
     * 那么二者相乘就是我们要的结果，所以我们只要分别创建出这两个数组即可，分别从数组的两个方向遍历就可以分别创建出乘积累积数组。
     * @param nums
     * @return
     */
    public int[] productExceptSelf02(int[] nums){
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for(int i = 1; i < n ; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }

        for(int i = n - 2; i >= 0; i--){
            right[i] = right[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < n; i++){
            res[i] = left[i] * right[i];
        }

        return res;
    }


    //method 3
    /**
     * 对上面的方法进行空间上的优化，由于最终的结果都是要乘到结果res中，所以我们可以不用单独的数组来保存乘积，而是直接累积到res中，
     * 我们先从前面遍历一遍，将乘积的累积存入res中，然后从后面开始遍历，用到一个临时变量right，初始化为1，然后每次不断累积，最终得到正确结果，
     */
    public int[] productExceptSelf03(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

}
