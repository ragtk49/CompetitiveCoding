/*
 * Leetcode 76. Minimum Window Substring (https://leetcode.com/problems/minimum-window-substring/)
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 */
package com.SlidingWindow;
/*
 * Approach:
 * 1. Use sliding window approach
 * 2. Use two pointers start and end
 * 3. Use two arrays to store the frequency of characters in the target string and the current window
 * 4. Calculate the frequency of characters in the target string
 * 5. Iterate through the second string
 * 6. Expand the window
 * 7. Check if the current window has the same frequency of characters as the target
 * 8. If yes, shrink the window from the left side
 * 9. Return the minimum window
 */
public class MinimumWindowSubstring {
    /*
     * Algorithm:
     * 1. Initialize start and end pointers to 0
     * 2. Initialize two arrays of size 128 to store the frequency of characters in the target string and the current window
     * 3. Calculate the frequency of characters in the target string
     * 4. Iterate through the second string
     * 5. Expand the window
     * 6. Check if the current window has the same frequency of characters as the target
     * 7. If yes, shrink the window from the left side
     * 8. Return the minimum window
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public String minWindow(String s, String t) {
        int[] targetFreq = new int[128];
        int[] windowFreq = new int[128];
        
        // Calculate the frequency of characters in the target string
        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }
        
        int start = 0, end = 0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        int requiredCharCount = t.length();
        
        while (end < s.length()) {
            // If the character at the end pointer exists in the target string
            if (targetFreq[s.charAt(end)] > 0) {
                if (windowFreq[s.charAt(end)] < targetFreq[s.charAt(end)]) {
                    requiredCharCount--;
                }
                windowFreq[s.charAt(end)]++;
            }
            
            // Try to shrink the window from the left side
            while (requiredCharCount == 0) {
                if (end - start + 1 < minLen) {
                    minStart = start;
                    minLen = end - start + 1;
                }
                
                if (targetFreq[s.charAt(start)] > 0) {
                    if (windowFreq[s.charAt(start)] <= targetFreq[s.charAt(start)]) {
                        requiredCharCount++;
                    }
                    windowFreq[s.charAt(start)]--;
                }
                
                start++;
            }
            
            end++;
        }
        
        // If no valid window is found
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        
        return s.substring(minStart, minStart + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(mws.minWindow(s, t));
    }
}
