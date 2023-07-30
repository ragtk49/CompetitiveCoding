/*
 * Leetcode 15. 3Sum (https://leetcode.com/problems/3sum/)
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
package com.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Approach: We can solve this problem using two pointers. We can sort the array and use two pointers to find the triplets.
 * We can iterate over the array and check if the sum of the numbers at the two pointers is equal to the target.
 * If yes, then we can add the triplet to the result. If no, then we can increment the left pointer if the sum is less than the target.
 * If the sum is greater than the target, then we can decrement the right pointer. We can continue this process until left < right.
 */
public class ThreeSum {
    /*
     * Algorithm:
     * 1. Sort the array.
     * 2. Iterate over the array until i < nums.length - 2.
     * 3. If i == 0 or (i > 0 and nums[i] != nums[i - 1]), then we can find the triplets.
     * 4. Initialize left to i + 1 and right to nums.length - 1.
     * 5. Calculate the sum of the numbers at the three pointers.
     * 6. If the sum is equal to the target, then add the triplet to the result.
     * 7. If the sum is less than the target, then increment the left pointer.
     * 8. If the sum is greater than the target, then decrement the right pointer.
     * 9. Return the result.
     * Time Complexity: O(N^2), where N is the length of nums. We traverse the array once and use two pointers to find the triplets.
     * Space Complexity: O(1). We don't use any extra space. 
     */
    public  List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                int target = -nums[i]; 
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum.threeSum(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
