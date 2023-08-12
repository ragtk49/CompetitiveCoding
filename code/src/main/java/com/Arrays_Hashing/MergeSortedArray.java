/*
 * Leetcode 88. Merge Sorted Array (https://leetcode.com/problems/merge-sorted-array/)
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * 1. The number of elements initialized in nums1 and nums2 are m and n respectively.
 * 2. You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 */
package com.Arrays_Hashing;
/*
 * Approach:
 * 1. Use three pointers p1, p2 and current to point to the end of nums1, nums2 and the end of the merged array respectively
 * 2. Compare the elements at p1 and p2 and place the greater element at current index
 * 3. Decrement p1 or p2 and current accordingly
 * 4. Repeat steps 2 and 3 until p1 or p2 becomes less than 0
 * 5. If p2 is greater than or equal to 0, place the remaining elements of nums2 into nums1
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int current = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[current] = nums1[p1];
                p1--;
            } else {
                nums1[current] = nums2[p2];
                p2--;
            }
            current--;
        }

        while (p2 >= 0) {
            nums1[current] = nums2[p2];
            p2--;
            current--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray ms = new MergeSortedArray();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        ms.merge(nums1, 3, nums2, 3);

        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
