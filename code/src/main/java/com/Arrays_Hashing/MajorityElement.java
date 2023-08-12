/*
 * Leetcode 169. Majority Element (https://leetcode.com/problems/majority-element/)
 * Given an array of size n, find the majority element. The majority element is the element that appears more than
 * ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * Example:
 * Input: [3,2,3]
 * Output: 3
 */
package com.Arrays_Hashing;
/*
 * Approach:
 * 1. Use two variables majority and count to store the majority element and its count respectively
 * 2. Iterate through the array and if count is 0, set majority to the current element and increment count
 * 3. If the current element is equal to majority, increment count, else decrement count
 * 4. Verify if majority is indeed the majority element by counting its occurrences
 * 5. If majority is the majority element, return it, else return -1
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
                count++;
            } else if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
        }
        
        // Verify if majority is indeed the majority element
        int occurrences = 0;
        for (int num : nums) {
            if (num == majority) {
                occurrences++;
            }
        }
        
        if (occurrences > nums.length / 2) {
            return majority;
        }
        
        // This will never be reached if the input satisfies the conditions
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(me.majorityElement(nums));
    }
}
