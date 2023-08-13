/*
 * Leetcode 189. Rotate Array (https://leetcode.com/problems/rotate-array/)
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 */
package com.Arrays_Hashing;
/*
 * Approach: Using Reverse 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RotateArray {
    /*
     * Algorithm:
     * 1. Reverse the entire array
     * 2. Reverse the first k elements
     * 3. Reverse the last n-k elements
     * 4. Return the array
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {   
            RotateArray rotateArray = new RotateArray();
            int[] nums = {1,2,3,4,5,6,7};
            int k = 3;
            rotateArray.rotate(nums, k);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
    }
}
