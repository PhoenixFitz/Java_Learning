package stage.two.klaus;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 */
public class SlidingWindowMaximum {


    //brute force
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k <= 0)
            return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for(int i = 0; i < n - k + 1; i++){
            res[i] = maxValue(nums, i, k);
        }
        return res;

    }

    public int maxValue(int[] nums, int start, int k){
        int max = Integer.MIN_VALUE;
        for(int i = start; i < start + k; i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    //deque

    /**
     * We scan the array from 0 to n-1, keep "promising" elements in the deque. The algorithm is amortized O(n) as each element is put and polled once.
     * At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means
     * 1.If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head,
     * as we are using a deque and elements are ordered as the sequence in the array
     *
     * 2.Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail.
     * This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window:
     * a[i] would always be a better candidate.
     *
     * 3.As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]
     */
    public int[] maxSlidingWindow02(int[] nums, int k){
        if(nums.length == 0 || k <= 0)
            return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int index = 0;
        // store index
        Deque<Integer> deque = new ArrayDeque<>();  //存储k范围的数组索引
        for(int i = 0; i < n; i++){
            // remove numbers out of range k
            while(!deque.isEmpty() && deque.peek() < i - k + 1){   //window [i-(k-1),i]
                deque.poll();
            }
            // remove smaller numbers in k range as they are useless
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            // deque contains index... res contains content
            deque.offer(i);
            if(i >= k - 1) {
                res[index] = nums[deque.peek()];
                index++;
            }
        }
        return res;
    }
}
