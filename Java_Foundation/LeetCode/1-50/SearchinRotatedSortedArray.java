package stage.one.klaus;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchinRotatedSortedArray {

    public static void main(String[] args){

    }

    public static int search (int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }else if(nums[i] > target){
                break;
            }
        }
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] == target){
                return i;
            }else if(nums[i] < target){
                break;
            }
        }
        return -1;
    }
    public static int search02(int[] nums, int target){
        if(nums==null || nums.length==0) return -1;
        int l=0, r=nums.length-1, m=0;
        // find out the index of the smallest element.
        while(l<r){
            m = (l+r)/2;
            if(nums[m] > nums[r]){
                l = m+1;
            }else{
                r = m;
            }
        }

        // since we now know the start, find out if the target is to left or right of start in the array.
        int s = l;
        l = 0; r = nums.length-1;
        if(target >= nums[s] && target <= nums[r]){
            l = s;
        }else{
            r = s;
        }
        // the regular search.
        while(l<=r){
            m = (l+r)/2;
            if(nums[m]==target) return m;
            else if(nums[m] > target) r = m-1;
            else l=m+1;
        }

        return -1;
    }
}
