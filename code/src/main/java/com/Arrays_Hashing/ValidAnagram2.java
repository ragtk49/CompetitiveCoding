/*
 * Leetcode 242. Valid Anagram (https://leetcode.com/problems/valid-anagram/)
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 */
package com.Arrays_Hashing;
/*
 * Approach: We can solev this problem by using an array of size 26. We can iterate over the first string and increment
 * the count of the character at the corresponding index in the array. Similarly, we can iterate over the second string
 * and decrement the count of the character at the corresponding index in the array. Finally, we can check if all the
 * values in the array are 0.
 */
public class ValidAnagram2 {
    /*
     * Algorithm:
     * 1. Create an array of size 26.
     * 2. Iterate over the first string and increment the count of the character at the corresponding index in the array.
     * 3. Iterate over the second string and decrement the count of the character at the corresponding index in the array.
     * 4. Check if all the values in the array are 0.
     * 5. Return true.
     * Time Complexity: O(N), where N is the length of s. We traverse the first string once.
     * Space Complexity: O(1), since the size of the array is fixed.
     */
    public boolean isAnagram(String s, String t){
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a'] = arr[s.charAt(i) - 'a'] + 1;
        }
        for(int i = 0; i < t.length(); i++){
            arr[t.charAt(i) - 'a'] = arr[t.charAt(i) - 'a'] - 1;
        }
        for( int val : arr){
            if(val != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram2 va = new ValidAnagram2();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(va.isAnagram(s, t));
    }
    
}
