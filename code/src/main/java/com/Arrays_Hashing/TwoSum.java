/*
 * Leetcode 1. Two Sum (https://leetcode.com/problems/two-sum/)
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * Time Complexity: O(n). We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
 * Space Complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
 */
package com.Arrays_Hashing;

import java.util.HashMap;

public class TwoSum {
    /*
     * We can solve this problem using Hashing. We can use a HashMap to store the elements of the array.
     * Then, we can iterate over the array and check if the complement of the current element is present in the HashMap.
     * If yes, then we can return the indices of the current element and the complement.
     * If no, then we can add the current element to the HashMap.
     * Algorithm:
     * 1. Create a HashMap.
     * 2. Iterate over the array.
     * 3. Check if the complement of the current element is present in the HashMap.
     * 4. If yes, then return the indices of the current element and the complement.
     * 5. If no, then add the current element to the HashMap.
     * 6. Return the result.
     * Time Complexity: O(n). We traverse the list containing n elements only once. Each look up in the table costs only O(1) time.
     * Space Complexity: O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
     */
    public int[] twoSum(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
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
