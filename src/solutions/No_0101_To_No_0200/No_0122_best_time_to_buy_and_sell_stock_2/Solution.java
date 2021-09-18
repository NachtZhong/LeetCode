package solutions.No_0101_To_No_0200.No_0122_best_time_to_buy_and_sell_stock_2;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * @author Nacht
 * Created on 2019/5/17
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 解题思路:
 * 题目: 数组代表每一天股票的价格, 求在这个价格基础下能获得的最大收益
 * 贪心算法思想, 两天之间只要是从小到大的价格波动, 这个盈利都吃到, 最终得到的就是最大收益
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0 ;
        for(int i = 0; i < prices.length - 1; i++){
            result += prices[i + 1] > prices[i] ? prices[i + 1] - prices[i] : 0;
        }
        return result;
    }
}
