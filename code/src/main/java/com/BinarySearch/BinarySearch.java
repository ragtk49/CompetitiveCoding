/*
 * Leetcode 704. Binary Search (https://leetcode.com/problems/binary-search/)
 * Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 * Example:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 */
package com.BinarySearch;
/*
 * Approach:
 * 1. Use two pointers left and right to point to the start and end of the array
 * 2. Calculate the mid index as (left + right) / 2
 * 3. If the element at mid index is equal to the target, return mid
 * 4. If the element at mid index is less than the target, move left to mid + 1
 * 5. If the element at mid index is greater than the target, move right to mid - 1
 * 6. Repeat steps 2 to 5 until left <= right
 * 7. Return -1 if the target is not found
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(bs.search(nums, target));
    }
}
