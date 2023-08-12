/*
 * Leetcode 26. Remove Duplicates from Sorted Array (https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Note: Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2]
 */
package com.Arrays_Hashing;
/*
 * Approach:
 * 1. Use two pointers p and i to point to the start of the array
 * 2. If the element at i index is not equal to the element at p index, increment p and place the element at i index at p index
 * 3. Repeat step 2 until i reaches the end of the array
 * 4. Return p + 1
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int p = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[p]) {
                p++;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray rd = new RemoveDuplicatesFromSortedArray();
        int[] nums = {1,1,2};
        System.out.println(rd.removeDuplicates(nums));
    }
}
