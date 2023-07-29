/*
 * Leetcode 242. Valid Anagram (https://leetcode.com/problems/valid-anagram/)
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * Time Complexity: O(n). Time complexity is O(n) because accessing the counter table is a constant time operation.
 * Space Complexity: O(1). Although we do use extra space, the space complexity is O(1) because the table's size stays constant no matter how large n is.
 */
package com.Arrays_Hashing;

public class ValidAnagram2 {
    /*
     * We can solve this problem using Hashing. We can use an array of size 26 to store the characters of the first string.
     * Then, we can iterate over the second string and check if the character is present in the array.
     * If yes, then we can decrement the count of the character in the array.
     * If no, then we can return false.
     * Algorithm:
     * 1. Check if the lengths of the strings are equal.
     * 2. If not, then return false.
     * 3. Create an array of size 26.
     * 4. Iterate over the first string and compare the character with 'a'.
     * 5. Increment the count of the character in the array.    
     * 6. Iterate over the second string and compare the character with 'a'.
     * 7. Decrement the count of the character in the array.
     * 8. Iterate over the array and check if all the values are 0.
     * 9. If yes, then return true.
     * 10. Else, return false.
     * Time Complexity: O(n). Time complexity is O(n) because accessing the counter table is a constant time operation.
     * Space Complexity: O(1). Although we do use extra space, the space complexity is O(1) because the table's size stays constant no matter how large n is.
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
