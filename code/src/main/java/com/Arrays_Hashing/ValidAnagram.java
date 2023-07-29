/*
 * Leetcode 242. Valid Anagram (https://leetcode.com/problems/valid-anagram/)
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Time Complexity: O(n). Time complexity is O(n) because accessing the counter table is a constant time operation.
 * Space Complexity: O(1). Although we do use extra space, the space complexity is O(1) because the table's size stays constant no matter how large n is.
 */
package com.Arrays_Hashing;

import java.util.HashMap;

public class ValidAnagram {
    /*
     * We can solve this problem using Hashing. We can use a HashMap to store the characters of the first string.
     * Then, we can iterate over the second string and check if the character is present in the HashMap.
     * If yes, then we can decrement the count of the character in the HashMap.
     * If no, then we can return false.
     * Algorithm:
     * 1. Check if the lengths of the strings are equal.
     * 2. If not, then return false.
     * 3. Create a HashMap.
     * 4. Iterate over the first string and add the characters to the HashMap.
     * 5. Iterate over the second string and check if the character is present in the HashMap.
     * 6. If yes, then decrement the count of the character in the HashMap.
     * 7. If no, then return false.
     * 8. Return true.
     * Time Complexity: O(n). Time complexity is O(n) because accessing the counter table is a constant time operation.
     * Space Complexity: O(1). Although we do use extra space, the space complexity is O(1) because the table's size stays constant no matter how large n is.
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
