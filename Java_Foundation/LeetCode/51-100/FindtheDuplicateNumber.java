package stage.two.klaus;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindtheDuplicateNumber {

    public int findDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if (!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return nums[i];
        }
        return 0;
    }



    //题目限定了区间 [1,n]，所以可以巧妙的利用坐标和数值之间相互转换，而由于重复数字的存在，那么一定会形成环，我们用快慢指针可以找到环并确定环的起始位置，
    // 参考网址http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
    public int findDuplicate03(int[] nums){
        int slow = 0, fast = 0, t = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
                break;;
        }
        while(true){
            slow = nums[slow];
            t = nums[t];
            if (slow == t)
                break;
        }
        return slow;

    }
}
