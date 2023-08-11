/*
 * Leetcode 84. Largest Rectangle in Histogram (https://leetcode.com/problems/largest-rectangle-in-histogram/)
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Example:
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
package com.Stacks;

import java.util.Stack;
/*
 * Approach:
 * 1. Use a stack to store the indices of the bars in increasing order of their heights
 * 2. If the current bar is smaller than the bar at the top of the stack, pop the stack and calculate the area
 * 3. The area is calculated as height of the bar at the top of the stack * (current index - index of the bar at the top of the stack - 1)
 * 4. If the stack is empty, the area is calculated as height of the current bar * current index
 * 5. Return the maximum area
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? n : n - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(lr.largestRectangleArea(heights));
    }
}
