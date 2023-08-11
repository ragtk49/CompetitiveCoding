/*
 * Leetcode 875. Koko Eating Bananas (https://leetcode.com/problems/koko-eating-bananas/)
 * Koko loves to eat bananas. There are N piles of bananas, the i-th pile has piles[i] bananas.
 * The guards have gone and will come back in H hours.
 * Koko can decide her bananas-per-hour eating speed of K. Each hour, she chooses some pile of bananas, and eats K bananas from that pile.
 * If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * Example 1:
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 */
package com.BinarySearch;
/*
 * Approach:
 * 1. Use two pointers left and right to point to the start and end of the array
 * 2. Calculate the mid index as (left + right) / 2
 * 3. Calculate the total hours required to eat all the bananas at the mid index speed
 * 4. If the total hours is greater than the given hours, move left to mid + 1
 * 5. If the total hours is less than or equal to the given hours, move right to mid
 * 6. Repeat steps 2 to 5 until left < right
 * 7. Return left
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = getTotalHours(piles, mid);

            if (hours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }

    private int getTotalHours(int[] piles, int K) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile + K - 1) / K;
        }
        return hours;
    }

    public static void main(String[] args) {
        KokoEatingBananas kb = new KokoEatingBananas();
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(kb.minEatingSpeed(piles, h));
    }
}
