/*
 * Leetcode 153. Find Minimum in Rotated Sorted Array (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * Example:
 * Input: [3,4,5,1,2]
 * Output: 1
 */
package com.BinarySearch;
/*
 * Approach:
 * 1. Use two pointers left and right to point to the start and end of the array
 * 2. Calculate the mid index as (left + right) / 2
 * 3. If the element at mid index is greater than the element at right index, move left to mid + 1
 * 4. If the element at mid index is less than or equal to the element at right index, move right to mid
 * 5. Repeat steps 2 to 4 until left < right
 * 6. Return the element at left index
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray fm = new FindMinimumInRotatedSortedArray();
        int[] nums = {3,4,5,1,2};
        System.out.println(fm.findMin(nums));
    }
}
