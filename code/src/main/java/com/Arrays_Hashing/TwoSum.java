/*
 * Leetcode 1. Two Sum (https://leetcode.com/problems/two-sum/)
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 */
package com.Arrays_Hashing;

import java.util.HashMap;
/*
 * Approach: We can solve this problem using Hashing. We can use a HashMap to store the elements of the array.
 * Then, we can iterate over the array and check if the complement of the current element is present in the HashMap.
 * If yes, then we can return the indices of the current element and the complement.
 * If no, then we can add the current element to the HashMap.
 */
public class TwoSum {
    /*
     * Algorithm:
     * 1. Create a HashMap.
     * 2. Iterate over the array.
     * 3. Check if the complement of the current element is present in the HashMap.
     * 4. If yes, then return the indices of the current element and the complement.
     * 5. If no, then add the current element to the HashMap.
     * 6. Return the result.
     * Time Complexity: O(N), where N is the length of nums. We traverse the array once.
     * Space Complexity: O(N), where N is the length of nums. We use a hashmap to store the elements of nums.
     * Note: We can also solve this problem using two pointers. We can sort the array and use two pointers to find the indices of the two numbers.
     * Time Complexity: O(NlogN), where N is the length of nums. We sort the array and traverse the array once.
     * Space Complexity: O(1).
     */
    public int[] twoSum(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                result = new int[]{map.get(complement), i};
            }
            else{
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = ts.twoSum(nums, target);
        for(int i : result){
            System.out.print(i + " ");
        }
    }
    
}
