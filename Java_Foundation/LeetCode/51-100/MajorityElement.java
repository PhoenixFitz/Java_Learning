package stage.two.klaus;
/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int maj = 0, count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(count < entry.getValue()){
                count = entry.getValue();
                maj = entry.getKey();
            }
        }
        return maj;
    }

    //sorting
    //If the elements are sorted in monotonically increasing (or decreasing) order, the majority element can be found at
    // index n/2(and n/2 incidentally, if n is even).
    public int majorityElement02(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
