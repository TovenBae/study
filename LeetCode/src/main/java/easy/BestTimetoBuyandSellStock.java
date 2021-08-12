package easy;


// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

//  You are given an array prices where prices[i] is the price of a given stock on the ith day.
//  You want to maximize your profit by choosing a single day to buy one stock
//  and choosing a different day in the future to sell that stock.
//  Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
//
//    Example 1:
//        Input: prices = [7,1,5,3,6,4]
//        Output: 5
//        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//
//    Example 2:
//        Input: prices = [7,6,4,3,1]
//        Output: 0
//        Explanation: In this case, no transactions are done and the max profit = 0.
//
//    Constraints:
//        1 <= prices.length <= 10E5
//        0 <= prices[i] <= 10E4

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BestTimetoBuyandSellStock {
    // Brute Force : Limit time exceeded
    public int maxProfit2(int[] prices) {
        if (prices == null)
            return 0;
        int maxProfits = 0;
        int tmp;
        for (int i=0; i<prices.length; i++) {
            for (int j=i; j<prices.length; j++) {
                tmp = prices[j] - prices[i];
                if (tmp > maxProfits) {
                    maxProfits = tmp;
                }
            }
        }
        return maxProfits;
    }

    // Solution : One Pass
    public int maxProfit3(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    // Solution :
    public int maxProfit(int[] prices) {
        int ans=0;
        if(prices.length==0)
        {
            return ans;
        }
        int bought=prices[0];
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>bought)
            {
                if(ans<(prices[i]-bought))
                {
                    ans=prices[i]-bought;
                }
            }
            else
            {
                bought=prices[i];
            }
        }
        return ans;
    }

    @Test
    public void test() {
        BestTimetoBuyandSellStock test = new BestTimetoBuyandSellStock();
        int [] prices;

        prices = new int[]{7,1,5,3,6,4};
        assertThat(test.maxProfit(prices), equalTo(5));

        prices = new int[]{7,6,4,3,1};
        assertThat(test.maxProfit(prices), equalTo(0));

    }
}
