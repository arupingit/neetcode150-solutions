package com.neetcode.slidingWindow;

/**
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * @author arupdutta
 *
 */
public class BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
		System.out.println(maxProfit(new int[]{7,6,4,3,1}));
	}
	
	public static int maxProfit(int[] prices) {
		int buyPointer = 0;
		int sellPointer = 1;
		int profit = 0;
		int tempProfit = 0;
		while(sellPointer<prices.length){
			if(prices[sellPointer]>prices[buyPointer]){
				tempProfit = prices[sellPointer] - prices[buyPointer];
				if(tempProfit>profit){
					profit = tempProfit;
				}
			} else {
				buyPointer = sellPointer;
			}
			sellPointer++;
		}
		return profit;
    }

}
