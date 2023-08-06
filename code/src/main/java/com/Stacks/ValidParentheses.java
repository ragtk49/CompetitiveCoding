/*
 * Leetcode 20. Valid Parentheses (https://leetcode.com/problems/valid-parentheses/)
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * Example 1:
 * Input: s = "()[]{}"
 * Output: true
 */
package com.Stacks;

import java.util.Stack;
/*
 * Approach: This is a classic stack problem. We can use a stack to store the opening brackets.
 * 1. Iterate through the string
 * 2. If the character is an opening bracket, push it to the stack
 * 3. If the character is a closing bracket, check if the stack is empty
 * 4. If the stack is empty, return false
 * 5. If the stack is not empty, pop the top element from the stack
 * 6. If the popped element is not the corresponding opening bracket, return false
 * 7. If the stack is empty, return true
 * 8. Return false
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ValidParentheses {
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        String s = "()[]{}";
        System.out.println(vp.isValid(s));
    }
}
