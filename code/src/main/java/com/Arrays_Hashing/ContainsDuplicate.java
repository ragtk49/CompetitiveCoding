/*
 * Leetcode 217. Contains Duplicate (https://leetcode.com/problems/contains-duplicate/)
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * Example 1:
 * Input: [1,2,3,1]
 * Output: true
 */

package com.Arrays_Hashing;

import java.util.HashSet;
import java.util.Set;
/*
 * Approach: We can solve this problem using Hashing. We can use a set to add the elements of the array. If the set already contains the element, then we can return true.
 * If we reach the end of the array, then we can return false.
 */
public class ContainsDuplicate {
    /*
     * Algorithm:
     * 1. Create a set.
     * 2. Iterate over the array.
     * 3. Check if the set contains the number.
     * 4. If yes, then return true.
     * 5. Else, add the number to the set.
     * 6. Return false.
     * Time Complexity: O(n). We do search() and insert() for n times and each operation takes constant time.
     * Space Complexity: O(n). The space used by a hash table is linear with the number of elements in it.
     */
    public boolean containsDuplicate(int[] nums){
        // Base case
        if(nums == null || nums.length == 0){
            return false;
        }
        // Create a set
        Set<Integer> set = new HashSet<>();
        // Iterate over the array
        for(int num : nums){
            // Check if the set contains the number
            if(set.contains(num)){
                return true; // Duplicate found
            }
            else{
                // Add the number to the set
                set.add(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate.containsDuplicate(nums));
    }
    
}
