/*
 * Leetcode 49. Group Anagrams (https://leetcode.com/problems/group-anagrams/)
 * Given an array of strings, group anagrams together.
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
package com.Arrays_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
 * Approach: We can solve this problem using Hashing. We can use a HashMap to store the sorted strings.
 * Then, we can iterate over the array and sort each string.
 * Then, we can check if the sorted string is present in the HashMap.
 * If yes, then we can add the string to the list of strings corresponding to the sorted string.
 * If no, then we can add the sorted string to the HashMap and add the string to the list of strings corresponding to the sorted string.
 */
public class GroupAnagrams {
    /*
     * Algorithm:
     * 1. Create a HashMap.
     * 2. Iterate over the array.
     * 3. Sort the string.
     * 4. Check if the sorted string is present in the HashMap.
     * 5. If yes, then add the string to the list of strings corresponding to the sorted string.
     * 6. If no, then add the sorted string to the HashMap and add the string to the list of strings corresponding to the sorted string.
     * 7. Return the result.
     */
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs == null || strs.length == 0){
            return null;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = ga.groupAnagrams(strs);
        System.out.println(result);
    }
    
}
