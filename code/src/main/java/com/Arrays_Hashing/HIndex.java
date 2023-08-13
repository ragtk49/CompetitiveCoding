/*
 * Leetcode 274. H-Index (https://leetcode.com/problems/h-index/)
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
 * return compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each,
 * and the other n − h papers have no more than h citations each.
 * If there are several possible values for h, the maximum one is taken as the h-index.
 * Example 1:
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 */
package com.Arrays_Hashing;
/*
 * Approach:
 * 1. Initialize count array of size n + 1
 * 2. Traverse the array and count the number of papers for each citation count
 * 3. Traverse the count array in reverse and return the first index where the number of papers is greater than or equal to the citation count
 * 4. Return 0
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        
        // Count the number of papers for each citation count
        for (int c : citations) {
            if (c >= n) {
                count[n]++;
            } else {
                count[c]++;
            }
        }
        
        int papers = 0;
        
        // Traverse count array in reverse
        for (int i = n; i >= 0; i--) {
            papers += count[i];
            if (papers >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int[] citations = {3,0,6,1,5};
        System.out.println(hIndex.hIndex(citations));
    }
}
