package easy;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete as many transactions as you like
// (i.e., buy one and sell one share of the stock multiple times).
// Note: You may not engage in multiple transactions simultaneously
// (i.e., you must sell the stock before you buy again).
//
//    Example 1:
//        Input: prices = [7,1,5,3,6,4]
//        Output: 7
//        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//    Example 2:
//        Input: prices = [1,2,3,4,5]
//        Output: 4
//        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//        Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
//    Example 3:
//        Input: prices = [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transaction is done, i.e., max profit = 0.
//
//    Constraints:
//        1 <= prices.length <= 3 * 10E4
//        0 <= prices[i] <= 10E4

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 )
            return 0;

        int sumProfit = 0;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        int minPrice2 = Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (maxProfit < (prices[i] - minPrice)) {
                maxProfit = prices[i] - minPrice;

                sumProfit += maxProfit;
                maxProfit = 0;
                minPrice = Integer.MAX_VALUE;
            }

        }
        return sumProfit;
    }

    // solution
    public int maxProfit_sol1(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }

    // Solution 2
    public int maxProfit_sol2(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    // solution 3
    public int maxProfit_sol3(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    @Test
    public void test() {
        BestTimetoBuyandSellStockII test = new BestTimetoBuyandSellStockII();
        int [] prices;

        prices = new int[]{7,1,5,3,6,4};
        assertThat(test.maxProfit_sol3(prices), equalTo(7));

        prices = new int[]{1,2,3,4,5};
        assertThat(test.maxProfit_sol3(prices), equalTo(4));

        prices = new int[]{7,6,4,3,1};
        assertThat(test.maxProfit_sol3(prices), equalTo(0));

        prices = new int[]{1,3,2,4,5};
        assertThat(test.maxProfit_sol3(prices), equalTo(5));

    }
}
