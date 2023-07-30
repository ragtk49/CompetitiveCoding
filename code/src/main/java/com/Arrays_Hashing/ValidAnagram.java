/*
 * Leetcode 242. Valid Anagram (https://leetcode.com/problems/valid-anagram/)
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 */
package com.Arrays_Hashing;

import java.util.HashMap;
/*
 * Approach: We can solve this problem using Hashing. We can use a HashMap to store the characters of the first string.
 * Then, we can iterate over the second string and check if the character is present in the HashMap.
 * If yes, then we can decrement the count of the character in the HashMap.
 * If no, then we can return false.
 */
public class ValidAnagram {
    /*
     * Algorithm:
     * 1. Create a HashMap.
     * 2. Iterate over the first string and store the characters in the HashMap.
     * 3. Iterate over the second string and check if the character is present in the HashMap.
     * 4. If yes, then decrement the count of the character in the HashMap.
     * 5. If no, then return false.
     * 6. Return true.
     * Time Complexity: O(N), where N is the length of s. We traverse the first string once.
     * Space Complexity: O(N), where N is the length of s. We use a hashmap to store the characters of s.
     */
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) - 1);
        }
        for(int val : map.values()){
            if(val != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(va.isAnagram(s, t));
    }
    
}
