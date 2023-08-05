/*
 * Leetcode 239. Sliding Window Maximum (https://leetcode.com/problems/sliding-window-maximum/)
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
 * Example 1:
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 */
package com.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
/*
 * Approach:
 * 1. Use sliding window approach
 * 2. Use a deque to store the indices of the elements in the current window
 * 3. Remove elements from the back of the deque if they are smaller than the current element
 * 4. Add current index to the back of the deque
 * 5. Remove elements from the front of the deque if they are outside the current window
 * 6. Add the maximum element to the result array if we have a valid window
 * 7. Return the result array
 */
public class SlidingWindowMaximum {
    /*
     * Algorithm:
     * 1. Initialize a result array of size n - k + 1
     * 2. Initialize a deque
     * 3. Iterate through the array
     * 4. Remove elements from the back of the deque if they are smaller than the current element
     * 5. Add current index to the back of the deque
     * 6. Remove elements from the front of the deque if they are outside the current window
     * 7. Add the maximum element to the result array if we have a valid window
     * 8. Return the result array
     * Time Complexity: O(n)
     * Space Complexity: O(k)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove elements from the back of the deque
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            
            // Add current index to the back of the deque
            deque.addLast(i);
            
            // Remove elements from the front of the deque if they are outside the current window
            if (deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }
            
            // Add the maximum element to the result array if we have a valid window
            if (i >= k - 1) {
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = swm.maxSlidingWindow(nums, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
