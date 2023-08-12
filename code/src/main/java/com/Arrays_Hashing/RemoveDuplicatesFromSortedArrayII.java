/*
 * Leetcode 80. Remove Duplicates from Sorted Array II (https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Note: Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example:
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3]
 */
package com.Arrays_Hashing;
/*
 * Approach:
 * 1. Use two pointers p and i to point to the start of the array
 * 2. If the element at i index is greater than the element at p - 2 index, place the element at i index at p index and increment p
 * 3. Repeat step 2 until i reaches the end of the array
 * 4. Return p
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int p = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[p - 2]) {
                nums[p] = nums[i];
                p++;
            }
        }

        return p;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII rd = new RemoveDuplicatesFromSortedArrayII();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(rd.removeDuplicates(nums));
    }
}
