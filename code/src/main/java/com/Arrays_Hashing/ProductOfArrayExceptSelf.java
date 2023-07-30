/*
 * Leetcode 238. Product of Array Except Self (https://leetcode.com/problems/product-of-array-except-self/)
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements
 * of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
package com.Arrays_Hashing;
/*
 * Approach: We can solve this problem using two arrays leftProduct and rightProduct. We can calculate the product of
 * all elements to the left of each element and store it in leftProduct array. Similarly, we can calculate the product
 * of all elements to the right of each element and store it in rightProduct array. Finally, we can calculate the final
 * result by multiplying leftProduct[i] and rightProduct[i].
 */
public class ProductOfArrayExceptSelf {
    /*
     * Algorithm:
     * 1. Create two arrays leftProduct and rightProduct of size n.
     * 2. Calculate the product of all elements to the left of each element and store it in leftProduct array.
     * 3. Calculate the product of all elements to the right of each element and store it in rightProduct array.
     * 4. Calculate the final result by multiplying leftProduct[i] and rightProduct[i].
     * Time Complexity: O(N), where N is the length of nums. We use one iteration to construct the array leftProduct,
     * one to construct the array rightProduct and one last to construct the answer array using nums, leftProduct and
     * rightProduct.
     * Space Complexity: O(N), where N is the length of nums. We use three arrays to keep our intermediate results.
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        
        // Calculate the product of all elements to the left of each element
        leftProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }
        
        // Calculate the product of all elements to the right of each element
        rightProduct[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }
        
        // Calculate the final result by multiplying leftProduct[i] and rightProduct[i]
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] result = productOfArrayExceptSelf.productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
