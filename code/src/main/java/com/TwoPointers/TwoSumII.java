/*
 * Leetcode: 167. Two Sum II - Input array is sorted (https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
 * Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add
 * up to a specific target number.
 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1]
 * <= numbers.length.  
 * Example 1:
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 */
package com.TwoPointers;
/*
 * Approach: We can solve this problem using two pointers. We can use two pointers, left and right, to find the indices of the two numbers.
 * We can initialize left to 0 and right to n - 1. Then, we can calculate the sum of the numbers at the two pointers. If the sum is equal to
 * the target, then we can return the indices of the two numbers. If the sum is less than the target, then we can increment the left pointer.
 * If the sum is greater than the target, then we can decrement the right pointer. We can continue this process until left < right.
 */
public class TwoSumII {
    /*
     * Algorithm:
     * 1. Create two pointers left and right.
     * 2. Iterate over the array until left < right.
     * 3. Calculate the sum of the numbers at the two pointers.
     * 4. If the sum is equal to the target, then return the indices of the two numbers.
     * 5. If the sum is less than the target, then increment the left pointer.
     * 6. If the sum is greater than the target, then decrement the right pointer.
     * 7. Return the result.
     * Time Complexity: O(N), where N is the length of numbers. We traverse the array once.
     * Space Complexity: O(1).
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // 1-based indexing
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0]; // If no valid solution found
    }

    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumII.twoSum(numbers, target);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
