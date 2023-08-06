/*
 * Leetcode 739. Daily Temperatures (https://leetcode.com/problems/daily-temperatures/)
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 */
package com.Stacks;

import java.util.Arrays;
import java.util.Stack;
/*
 * Approach: We can use a stack to solve this problem.
 * 1. Initialize a result array of size n
 * 2. Initialize a stack
 * 3. Iterate through the array
 * 4. While the stack is not empty and the current temperature is greater than the temperature at the top of the stack
 * 5. Pop the top element from the stack
 * 6. Add the difference between the current index and the index of the popped element to the result array
 * 7. Push the current index to the stack
 * 8. Return the result array
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        DailyTemperatures dt = new DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dt.dailyTemperatures(temperatures)));
    }
}
