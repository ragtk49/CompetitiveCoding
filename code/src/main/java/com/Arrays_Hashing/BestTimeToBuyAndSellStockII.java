/*
 * Leetcode 122. Best Time to Buy and Sell Stock II (https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 */
package com.Arrays_Hashing;
/*
 * Approach :
 * 1. Initialize maxProfit to 0
 * 2. Iterate through the array
 * 3. If the current price is greater than the previous price, update maxProfit
 * 4. Return maxProfit
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(bestTimeToBuyAndSellStockII.maxProfit(prices));
    }
}
