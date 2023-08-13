/*
 * Leetcode 45. Jump Game II (https://leetcode.com/problems/jump-game-ii/)
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position. Your goal is to reach the
 * last index in the minimum number of jumps. You can assume that you can always reach the last index.
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 */
package com.Arrays_Hashing;
/*
 * Approach:
 * 1. Initialize endReach and maxReach to 0 and jumps to 0
 * 2. Iterate through the array
 * 3. Update maxReach to max(maxReach, i + nums[i])
 * 4. If i == endReach, update jumps and endReach
 * 5. If endReach >= nums.length - 1, return jumps
 * 6. Return -1
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int endReach = 0;
        int maxReach = 0;
        int jumps = 0;
        
        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == endReach) {
                jumps++;
                endReach = maxReach;
            }
            if (endReach >= nums.length - 1) {
                return jumps;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        int[] nums = {2,3,1,1,4};
        System.out.println(jumpGameII.jump(nums));
    }
}
