/*
 * Leetcode: 279. Perfect Squares (https://leetcode.com/problems/perfect-squares/)
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n. For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2
 * because 13 = 4 + 9. 
 * Time Complexity: O(n * sqrt(n)). For each i from 1 to n, we are looping over
 * sqrt(n) values to find the minimum.
 * Space Complexity: O(n). dp array of size n is used.
 */


package com.Queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Queue;

public class PerfectSquares {
    /*
     * We can solve this problem using Breadth First Search (BFS). We can think of
     * this problem as a shortest path problem on a graph: There are n nodes (1 to
     * n), and there is an edge between two nodes if they differ by a square number
     * (i.e. 1, 4, 9, 16, ...). Our problem reduces to finding the shortest path from
     * the node 1 to the node n.
     * Algorithm:
     * 1. We can use a breadth-first search to solve this problem, as it naturally considers nodes
     * "level-by-level". Intuitively, nodes which are a "greater distance" from the root are farther away,
     * so if we visit the neighbors level-by-level, then we have visited the closer nodes first.
     * 2. We start our search at the root node 1 and keep a track of the distance travelled from the root.
     * 3. For each node, we'll explore all of its neighbors that aren't in deadends, and add those to the next level.
     * 4. We'll stop when we find the target node, or there are no more nodes to explore.
     * 5. To avoid visiting a node twice, we'll use a seen set to store the values of nodes that we've visited.
     * 6. Time Complexity: O(n * sqrt(n)). For each i from 1 to n, we are looping over sqrt(n) values to find the minimum.
     * 7. Space Complexity: O(n).
     * 8. Note that formally, we should also consider the memory used by the implicit call stack when performing a breadth-first search,
     * which might overflow in some cases. For brevity, we won't include it in our complexity analysis.
     */
    public int numSquares(int n) {
        // Create a queue
        Queue<Integer> queue = new LinkedList<>();
        // Create a visited set
        Set<Integer> visited = new HashSet<>();
        // Add the initial state to the queue
        queue.add(n);
        // Add the initial state to the visited set
        visited.add(n);
        // Initialize the level to 0
        int level = 0;
        // Iterate until the queue is empty
        while (!queue.isEmpty()) {
            // Increment the level
            int size = queue.size();
            // Iterate over the queue
            for (int i = 0; i < size; i++) {
                // Remove the element from the queue
                int num = queue.poll();
                // Check if the number is 0
                // If yes, then return the level
                if (num == 0) {
                    return level;
                }
                // Iterate over the squares
                // Add the squares to the queue
                for (int j = 1; j * j <= num; j++) {
                    // Calculate the next number
                    int nextNum = num - j * j;
                    // Check if the next number is not visited
                    // If yes, then add the next number to the queue
                    if (!visited.contains(nextNum)) {
                        queue.add(nextNum);
                        visited.add(nextNum);
                    }
                }
            }
            // Increment the level
            level++;
        }
        // Return -1    
        return -1;
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();
        int n = 12;
        System.out.println(ps.numSquares(n));
    }
}
