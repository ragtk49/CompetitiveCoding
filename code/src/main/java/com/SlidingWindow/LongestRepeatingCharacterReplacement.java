/*
 * Leetcode 424. Longest Repeating Character Replacement (https://leetcode.com/problems/longest-repeating-character-replacement/)
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Output: 4
 */
package com.SlidingWindow;
/*
 * Approach:
 * 1. Use sliding window approach
 * 2. Use two pointers start and end
 * 3. Use an array to store the count of characters
 * 4. Use a variable maxFreq to store the maximum frequency of a character
 * 5. Use a variable maxLen to store the maximum length of the substring
 * 6. Iterate through the string
 * 7. Increment the count of the character at end pointer
 * 8. Update maxFreq
 * 9. If the length of the substring - maxFreq > k, decrement the count of the character at start pointer and increment start pointer
 * 10. Update maxLen
 * 11. Return maxLen
 */
public class LongestRepeatingCharacterReplacement {
    /*
     * Algorithm:
     * 1. Initialize start and end pointers to 0
     * 2. Initialize maxLen to 0
     * 3. Initialize an array to store the count of characters
     * 4. Initialize a variable maxFreq to store the maximum frequency of a character
     * 5. Iterate through the string
     * 6. Increment the count of the character at end pointer
     * 7. Update maxFreq
     * 8. If the length of the substring - maxFreq > k, decrement the count of the character at start pointer and increment start pointer
     * 9. Update maxLen
     * 10. Return maxLen
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] charCount = new int[26];
        int start = 0, end = 0;
        int maxFreq = 0;
        int maxLen = 0;
        
        while (end < n) {
            charCount[s.charAt(end) - 'A']++;
            maxFreq = Math.max(maxFreq, charCount[s.charAt(end) - 'A']);
            
            if (end - start + 1 - maxFreq > k) {
                charCount[s.charAt(start) - 'A']--;
                start++;
            }
            
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement lrcr = new LongestRepeatingCharacterReplacement();
        String s = "AABABBA";
        int k = 1;
        System.out.println(lrcr.characterReplacement(s, k));
    }
}
