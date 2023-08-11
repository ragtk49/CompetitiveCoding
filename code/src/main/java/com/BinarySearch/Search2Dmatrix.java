/*
 * Leetcode 74. Search a 2D Matrix (https://leetcode.com/problems/search-a-2d-matrix/)
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 * Example:
 * Input: matrix = [
 *                 [1,3,5,7],
 *                [10,11,16,20],
 *               [23,30,34,50]
 *               ]
 * target = 3
 * Output: true
 */
package com.BinarySearch;
/*
 * Approach:
 * 1. Use two pointers left and right to point to the start and end of the array
 * 2. Calculate the mid index as (left + right) / 2
 * 3. Calculate the row and column of the mid index as row = mid / n and col = mid % n
 * 4. If the element at mid index is equal to the target, return true
 * 5. If the element at mid index is less than the target, move left to mid + 1
 * 6. If the element at mid index is greater than the target, move right to mid - 1
 * 7. Repeat steps 2 to 6 until left <= right
 * 8. Return false if the target is not found
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class Search2Dmatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2Dmatrix sm = new Search2Dmatrix();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 3;
        System.out.println(sm.searchMatrix(matrix, target));
    }
}
