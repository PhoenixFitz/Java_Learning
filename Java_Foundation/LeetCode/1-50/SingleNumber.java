package leetcode.klaus;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {

    public static void main(String[] args){
        int[] nums = {1,3,4,1,6,4,6};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
                continue;
            }
            set.add(num);
        }
        Object[] s = set.toArray();
        return (Integer)s[0];
    }


    //利用异或运算符 ^  ，we have to know the bitwise XOR in java：0 ^ N = N  ， N ^ N = 0,


    public int singleNumber02(int[] nums){
        int res = 0;
        for(int num : nums){
            res = res ^ num;
        }
        return res;
    }

}








