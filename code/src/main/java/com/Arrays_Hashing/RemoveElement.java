/*
 * Leetcode 27. Remove Element (https://leetcode.com/problems/remove-element/)
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Note: Do not allocate extra space for another array, you must do this by modifying the input array in-place
 * with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example:
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2]
 */
package com.Arrays_Hashing;
/*
 * Approach:
 * 1. Use two pointers p and i to point to the start of the array
 * 2. If the element at i index is not equal to val, place the element at i index at p index and increment p
 * 3. Repeat step 2 until i reaches the end of the array
 * 4. Return p
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[p] = nums[i];
                p++;
            }
        }

        return p;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        int[] nums = {3,2,2,3};
        int val = 3;

        System.out.println(re.removeElement(nums, val));
    }
}
