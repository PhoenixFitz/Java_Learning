package stage.two.klaus;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 */
public class KthLargestElementinanArray {

//利用自带的排序
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(nums);
        return nums[nums.length - k];
    }
//快速排序
    /**
     * 快速排序Quick Sort的思想，这里排序的方向是从大往小排。核心思想是每次都要先找一个中枢点Pivot，然后遍历其他所有的数字，
     * 像这道题从大往小排的话，就把大于中枢点的数字放到左半边，把小于中枢点的放在右半边，这样中枢点是整个数组中第几大的数字就确定了，
     * 虽然左右两部分各自不一定是完全有序的，但是并不影响本题要求的结果，因为左半部分的所有值都大于右半部分的任意值，所以我们求出中枢点的位置，
     * 如果正好是k-1，那么直接返回该位置上的数字；如果大于k-1，说明要求的数字在左半部分，更新右边界，再求新的中枢点位置；反之则更新右半部分，求中枢点的位置；
     */
    public int findKthLargest02(int[] nums, int k){
        int pivot;
        int left = 0;
        int right = nums.length - 1;
        while(true){
            pivot = quickSort(nums, left, right);
            if(pivot == k - 1)
                return nums[pivot];
            else if(pivot > k -1)
                right = pivot - 1;
            else
                left = pivot + 1;
        }
    }
    public int quickSort (int[] nums, int left, int right){
        int pivot = nums[left];
        int l = left;
        int r = right;

        while(l < r){
            while(l < r && pivot >= nums[r])
                r--;
            if(l < r){
                nums[l] = nums[r];
                left++;
            }
            while(l < r && pivot <= nums[l])
                l++;
            if(l < r){
                nums[r] = nums[l];
                r--;
            }
        }
        nums[l] = pivot;
        return l;
    }

}
