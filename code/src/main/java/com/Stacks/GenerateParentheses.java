/*
 * Leetcode 22. Generate Parentheses (https://leetcode.com/problems/generate-parentheses/)
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 */
package com.Stacks;

import java.util.ArrayList;
import java.util.List;
/*
 * Approach: We can use backtracking to solve this problem.
 * 1. Initialize a list to store the result
 * 2. Call the helper function with the result, current string, open count, close count and n
 * 3. If the open count and close count are equal to n, add the current string to the result and return
 * 4. If the open count is less than n, call the helper function with the current string + "(", open count + 1, close count and n
 * 5. If the close count is less than open count, call the helper function with the current string + ")", open count, close count + 1 and n
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, "", 0, 0, n);
        return result;
    }

    private void generateParenthesisHelper(List<String> result, String current, int openCount, int closeCount, int n) {
        if (openCount == n && closeCount == n) {
            result.add(current);
            return;
        }

        if (openCount < n) {
            generateParenthesisHelper(result, current + "(", openCount + 1, closeCount, n);
        }

        if (closeCount < openCount) {
            generateParenthesisHelper(result, current + ")", openCount, closeCount + 1, n);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}
