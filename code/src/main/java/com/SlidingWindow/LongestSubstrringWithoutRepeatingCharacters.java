/*
 * Leetcode 3. Longest Substring Without Repeating Characters (https://leetcode.com/problems/longest-substring-without-repeating-characters/)
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 */
package com.SlidingWindow;

import java.util.HashSet;
/*
 * Approach:
 * 1. Use sliding window approach
 * 2. Use two pointers start and end
 * 3. Use a hashset to store the characters
 * 4. If the character is not present in the hashset, add it to the hashset and increment end pointer
 * 5. If the character is present in the hashset, remove the character from the hashset and increment start pointer
 * 6. Keep track of the max length of the substring 
 * 7. Return the max length
 */
public class LongestSubstrringWithoutRepeatingCharacters {
    /*
     * Algorithm:
     * 1. Initialize start and end pointers to 0
     * 2. Initialize maxLen to 0
     * 3. Initialize a hashset to store the characters
     * 4. Iterate through the string
     * 5. If the character is not present in the hashset, add it to the hashset and increment end pointer
     * 6. If the character is present in the hashset, remove the character from the hashset and increment start pointer
     * 7. Keep track of the max length of the substring
     * 8. Return the max length
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0, end = 0;
        int maxLen = 0;
        HashSet<Character> charSet = new HashSet<>();
        
        while (end < n) {
            if (!charSet.contains(s.charAt(end))) {
                charSet.add(s.charAt(end));
                maxLen = Math.max(maxLen, end - start + 1);
                end++;
            } else {
                charSet.remove(s.charAt(start));
                start++;
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstrringWithoutRepeatingCharacters lswrc = new LongestSubstrringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        System.out.println(lswrc.lengthOfLongestSubstring(s));
    }
}
