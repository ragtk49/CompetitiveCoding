/*
 * Leetcode 125. Valid Palindrome (https://leetcode.com/problems/valid-palindrome/)
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 */
package com.TwoPointers;
/*
 * Approach: We can solve this problem using two pointers. We can use one pointer to traverse the string from the left
 * and another pointer to traverse the string from the right. We can ignore the non-alphanumeric characters and compare
 * the characters at the two pointers. If the characters are not equal, then we can return false. If the characters are
 * equal, then we can increment the left pointer and decrement the right pointer. We can continue this process until
 * the left pointer is less than the right pointer.
 */
public class ValidPalindrome {
    /*
     * Algorithm:
     * 1. Create two pointers left and right.
     * 2. Iterate over the string until left < right.
     * 3. Ignore the non-alphanumeric characters.
     * 4. Compare the characters at the two pointers.
     * 5. If the characters are not equal, then return false.
     * 6. If the characters are equal, then increment the left pointer and decrement the right pointer.
     * 7. Return true.
     * Time Complexity: O(N), where N is the length of s. We traverse the string once.
     * Space Complexity: O(1).
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else if (leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
