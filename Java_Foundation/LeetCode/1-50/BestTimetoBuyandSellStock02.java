package stage.one.klaus;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStock02 {

    //Brute Force
    public int maxProfit(int[] prices) {
        return caculate(prices, 0);
    }

    public int caculate(int[] prices, int s){
        if(s >= prices.length)
            return 0;
        int max = 0;
        for(int i = s; i < prices.length; i++)
            for(int j = i + 1; j < prices.length; j++){
                if(prices[i] < prices[j]){
                    max = Math.max(max, prices[j] - prices[i] + caculate(prices, j + 1));
                }
            }

        return max;
    }

    //Peak Valley Approach
    //The key point is we need to consider every peak immediately following a valley to maximize the profit.
    // In case we skip one of the peaks (trying to obtain more profit), we will end up losing the profit over one of the transactions leading to an overall lesser profit.
    public int maxProfit02(int[] prices){
        if(prices.length == 0)
            return 0;
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int max = 0;
        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] > prices[i + 1])
                i++;
            valley = prices[i];
            while(i < prices.length - 1 && prices[i] < prices[i + 1])
                i++;
            peak = prices[i];
            max += peak - valley;
            i++;
        }
        return max;
    }

    //Simple One Pass
    public int maxProfit03(int[] prices){
        int max = 0;
        for(int i = 1; i < prices.length; i++){  //当length小于2时，循环不执行，因此不用判空
            if(prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;

    }

}
