/*
* Leetcode 347. Top K Frequent Elements (https://leetcode.com/problems/top-k-frequent-elements/)
* Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
* Example 1:
* Input: nums = [1,1,1,2,2,3], k = 2
* Output: [1,2]
* */
package com.Arrays_Hashing;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKElements {
    /*
     * Time Complexity: O(Nlogk), where N is the length of nums. We count the frequency of each number in O(N) time,
     * then we add N numbers to the heap, each in O(logk) time. Finally, we pop from the heap up to k times.
     * As k≤N, this is O(Nlogk) in total.
     * Space Complexity: O(N), the space used to store our count.
     * Approach: We can use a min-heap to store the k most frequent elements. We can iterate over the hashmap and add
     * elements to the min-heap. If the size of the min-heap exceeds k, we remove the top element from the min-heap.
     * Algorithm:
     * 1. Create a hashmap to store the frequency of each element.
     * 2. Create a min-heap to store the k most frequent elements.
     * 3. Traverse the hashmap and add elements to the min-heap.
     * 4. Create the result array and add elements from the min-heap.
     */
    public int[] topKFrequent(int[] nums, int k){
        // Create a hashmap to store the frequency of each element
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Create a min-heap to store the k most frequent elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));
        
        // Traverse the hashmap and add elements to the min-heap
        for (int num : frequencyMap.keySet()) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Create the result array and add elements from the min-heap
        int[] result = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }
        
        return result;
    }

    public static void main(String[] args) {
        TopKElements topKElements = new TopKElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKElements.topKFrequent(nums, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
    
}
