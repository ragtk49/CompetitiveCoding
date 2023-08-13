/*
 * Leetcode 55. Jump Game (https://leetcode.com/problems/jump-game/)
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 */
package com.Arrays_Hashing;
/*
 * Approach:
 * 1. Initialize maxReach to 0
 * 2. Iterate through the array
 * 3. If the current index is greater than maxReach, return false
 * 4. Update maxReach to max(maxReach, i + nums[i])
 * 5. If maxReach >= nums.length - 1, return true
 * 6. Return false
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums = {2,3,1,1,4};
        System.out.println(jumpGame.canJump(nums));
    }
}
