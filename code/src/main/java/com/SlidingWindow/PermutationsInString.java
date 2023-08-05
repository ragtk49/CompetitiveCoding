/*
 * Leetcode: 567. Permutation in String (https://leetcode.com/problems/permutation-in-string/)
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 */
package com.SlidingWindow;

import java.util.Arrays;
/*
 * Approach:
 * 1. Use sliding window approach
 * 2. Use two pointers start and end
 * 3. Use two arrays to store the frequency of characters in the target string and the current window
 * 4. Calculate the frequency of characters in the target string
 * 5. Iterate through the second string
 * 6. Expand the window
 * 7. Check if the current window has the same frequency of characters as the target
 * 8. If yes, return true
 * 9. If no, shrink the window from the left side
 * 10. Return false
 */
public class PermutationsInString {
    /*
     * Algorithm:
     * 1. Initialize start and end pointers to 0
     * 2. Initialize two arrays to store the frequency of characters in the target string and the current window
     * 3. Calculate the frequency of characters in the target string
     * 4. Iterate through the second string
     * 5. Expand the window
     * 6. Check if the current window has the same frequency of characters as the target
     * 7. If yes, return true
     * 8. If no, shrink the window from the left side
     * 9. Return false
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean checkInclusion(String s1, String s2) {
        int[] targetFreq = new int[26];
        int[] windowFreq = new int[26];
        
        // Calculate the frequency of characters in the second string (target)
        for (char c : s1.toCharArray()) {
            targetFreq[c - 'a']++;
        }
        
        int start = 0, end = 0;
        int len1 = s1.length();
        
        while (end < s2.length()) {
            // Expand the window
            windowFreq[s2.charAt(end) - 'a']++;
            
            // Check if the current window has the same frequency of characters as the target
            if (end - start + 1 == len1) {
                if (Arrays.equals(targetFreq, windowFreq)) {
                    return true;
                }
                
                // Shrink the window from the left side
                windowFreq[s2.charAt(start) - 'a']--;
                start++;
            }
            
            end++;
        }
        
        return false;
    }

    public static void main(String[] args) {
        PermutationsInString pis = new PermutationsInString();
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(pis.checkInclusion(s1, s2));
    }
}
