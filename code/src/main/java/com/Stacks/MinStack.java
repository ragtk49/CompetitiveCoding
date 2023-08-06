/*
 * Leetcode 155. Min Stack (https://leetcode.com/problems/min-stack/)
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * 1. MinStack() initializes the stack object.
 * 2. void push(val) pushes the element val onto the stack.
 * 3. void pop() removes the element on the top of the stack.
 * 4. int top() gets the top element of the stack.
 * 5. int getMin() retrieves the minimum element in the stack.
 * Example 1:
 * Input : ["MinStack","push","push","push","getMin","pop","top","getMin"]
 *        [[],[-2],[0],[-3],[],[],[],[]]
 * Output: [null,null,null,null,-3,null,0,-2]
 */
package com.Stacks;

import java.util.Stack;
/*
 * Approach: We can use two stacks to solve this problem. One stack to store the data and another stack to store the minimum element.
 * 1. Use two stacks to store the data and the minimum element
 * 2. Push the element to the data stack
 * 3. If the min stack is empty or the element is less than or equal to the top element of the min stack, push the element to the min stack
 * 4. Else, push the top element of the min stack to the min stack
 * 5. Pop the element from the data stack
 * 6. Pop the element from the min stack
 * 7. Return the top element of the data stack
 * 8. Return the top element of the min stack
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 */
public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /** Initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        dataStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(2);
        ms.push(4);
        ms.push(1);
        ms.push(3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}
