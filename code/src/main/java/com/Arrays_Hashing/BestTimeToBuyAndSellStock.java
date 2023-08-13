/*
 * Leetcode 121. Best Time to Buy and Sell Stock (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 */
package com.Arrays_Hashing;
/*
 * Approach :
 * 1. Initialize minPrice to Integer.MAX_VALUE and maxProfit to 0
 * 2. Iterate through the array
 * 3. If the current price is less than minPrice, update minPrice
 * 4. Else, update maxProfit
 * 5. Return maxProfit
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }
}
