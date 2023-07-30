/*
 * Leetcode 128. Longest Consecutive Sequence (https://leetcode.com/problems/longest-consecutive-sequence/)
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 */
package com.Arrays_Hashing;

import java.util.HashSet;
import java.util.Set;

/*
 * Approach: We can use a hashset to store all the elements of nums. We can traverse the nums array and check if the
 * current element is the starting element of a sequence. If yes, then we check the length of the sequence. We return
 * the maximum length of the sequence.
 */
public class LongestConsecutiveSequence {
    /*
     * Algorithm:
     * 1. Create a hashset to store all the elements of nums.
     * 2. Traverse the nums array and check if the current element is the starting element of a sequence.
     * 3. If yes, then check the length of the sequence.
     * 4. Return the maximum length of the sequence.
     * Time Complexity: O(N), where N is the length of nums. We traverse the array once.
     * Space Complexity: O(N), where N is the length of nums. We use a hashset to store the elements of nums.
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int maxSequenceLength = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) { // Check if num is the starting element of a sequence
                int currentNum = num;
                int currentSequenceLength = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequenceLength++;
                }
                
                maxSequenceLength = Math.max(maxSequenceLength, currentSequenceLength);
            }
        }
        return maxSequenceLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }
    
}
