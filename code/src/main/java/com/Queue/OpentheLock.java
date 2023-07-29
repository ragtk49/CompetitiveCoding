/*
 * Leetcode 752. Open the Lock (https://leetcode.com/problems/open-the-lock/)
 * You have a lock in front of you with 4 circular wheels.
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0',
 * or '0' to be '9'. Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * Time Complexity: O(n^2 * A^n + D) where n is the number of digits in the lock, A is the number of digits in our alphabet,
 * and D is the size of deadends. We might visit every lock combination, plus we need to instantiate our set dead.
 * Space Complexity: O(A^n + D), for the queue and the set dead.
 */

package com.Queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Queue;

/*
* We can think of this problem as a shortest path problem on a graph:
* There are 10000 nodes (strings '0000' to '9999'), and there is an edge between two nodes
* if they differ in one digit, that digit differs by 1 (wrapping around, so '0' and '9' differ by 1),
* and if both nodes are not in deadends. Our problem reduces to finding the shortest path from
* the node '0000' to the node target.
* Algorithm:
* 1. We can use a breadth-first search to solve this problem, as it naturally considers nodes
* "level-by-level". Intuitively, nodes which are a "greater distance" from the root are farther away,
* so if we visit the neighbors level-by-level, then we have visited the closer nodes first.
* 2. We start our search at the root node '0000' and keep a track of the distance travelled from the root.
* 3. For each node, we'll explore all of its neighbors that aren't in deadends, and add those to the next level.
* 4. We'll stop when we find the target node, or there are no more nodes to explore.
* 5. To avoid visiting a node twice, we'll use a seen set to store the values of nodes that we've visited.
* 6. Time Complexity: O(n^2 * A^n + D) where n is the number of digits in the lock, A is the number of digits in our alphabet,
* and D is the size of deadends. We might visit every lock combination, plus we need to instantiate our set dead.
* 7. Space Complexity: O(A^n + D), for the queue and the set dead.
* 8. Note that formally, we should also consider the memory used by the implicit call stack when performing a breadth-first search,
* which might overflow in some cases. For brevity, we won't include it in our complexity analysis.
* 9. The complexity of breadth-first search is the same as depth-first search, as discussed here.
* 10. We can also use a bidirectional breadth-first search, which is a bit more complicated.
* 11. We'll have two searches, one from the root and one from the target, and alternate between them on each iteration.
* 12. This is also a shortest path problem, but instead of searching one level at a time.       
*/
public class OpentheLock {

    public int openLock(String[] deadends, String target){
        // Convert the deadends array into a set
        Set<String> deadendSet = new HashSet();
        // Add all the deadends to the set
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }
        // If the initial state is a deadend then return -1
        String start = "0000";
        if (deadendSet.contains(start)) {
            return -1; // The initial state is a deadend
        }
        // If the target state is a deadend then return -1
        Queue<String> queue = new LinkedList();
        // Add the initial state to the queue
        Set<String> visited = new HashSet();
        // Add the initial state to the visited set
        queue.offer(start);
        // Add the initial state to the queue
        visited.add(start);
        
        int turns = 0;
        /*
         * Perform a breadth-first search starting from the initial state '0000'
         */
        while (!queue.isEmpty()) {
            // Get the size of the queue
            int size = queue.size();
            // Iterate through all the elements in the queue
            for (int i = 0; i < size; i++) {
                // Get the current state
                String current = queue.poll();
                // Check if the current state is equal to the target state
                // If yes then return the number of turns
                if (current.equals(target)) {
                    return turns;
                }
                /*
                 * Generate all the possible states one move away from the current state
                 * and check if they are not deadends and not visited before
                 * If yes then add them to the queue and the visited set
                 * If no then ignore them
                 * The possible states are generated by rotating each wheel of the lock
                 * in both the directions
                 * For example, if the current state is '0000' then the possible states
                 * are '1000', '9000', '0100', '0900', '0010', '0090', '0001', '0009'
                 * Note that the possible states are generated by rotating each wheel   
                 * of the lock in both the directions
                 */
                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        String next = rotateWheel(current, j, k);
                        if (!visited.contains(next) && !deadendSet.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
            // Increment the number of turns
            turns++;
        }

        return -1; // Target combination is not reachable   
    }
    
    private String rotateWheel(String combination, int wheelIndex, int direction) {
        // Rotate the wheel at the given index in the given direction
        char[] chars = combination.toCharArray();
        // Get the digit at the given index
        // Convert the digit from char to int
        // Apply the rotation considering wrapping around
        int digit = chars[wheelIndex] - '0';
        // Apply the rotation considering wrapping around
        digit = (digit + direction + 10) % 10;
        // Convert the digit from int to char
        // Update the digit at the given index
        chars[wheelIndex] = (char) (digit + '0');
        return new String(chars);
    }
    
    public static void main(String[] args) {
        OpentheLock opentheLock = new OpentheLock();
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(opentheLock.openLock(deadends, target));
    }
    
}
