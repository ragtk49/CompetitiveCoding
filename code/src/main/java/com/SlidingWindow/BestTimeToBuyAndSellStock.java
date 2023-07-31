/*
 * Leetcode 121. Best Time to Buy and Sell Stock (https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
 * Say you have an array for which the ith element is the price of a given stock on day i. If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit. Note that you cannot sell a stock before you buy one.
 * Example 1: Input: [7,1,5,3,6,4] 
 * Output: 5 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 */
package com.SlidingWindow;
/*
 * Approach:
 * 1. Keep track of the minimum price seen so far and the maximum profit seen so far.
 * 2. For every price, calculate the maximum profit if we sell the stock on that day.
 * 3. Update the maximum profit if we find a greater profit.
 * 4. Update the minimum price if we find a smaller price.
 * 5. Return the maximum profit.
 */
public class BestTimeToBuyAndSellStock {
    /*
     * Algorithm:
     * 1. Initialize minPrice = prices[0] and maxProfit = 0.
     * 2. Iterate over prices, starting from index 1:
     * 3. Update maxProfit, if prices[i] - minPrice > maxProfit.
     * 4. Update minPrice, if prices[i] < minPrice.
     * 5. Return maxProfit.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2)
            return 0;
        
        int minPrice = prices[0];
        int maxProfit = 0;
        
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit; 
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(b.maxProfit(prices));
    }
}
