package stage.one.klaus;

/**
 *Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 */
public class BestTimetoBuyandSellStock {

    //暴力解法
    public int maxProfit(int[] prices) {

        if(prices.length == 0 || prices.length == 1)
            return 0;
        int max = 0;
        for(int i = 0; i < prices.length; i++)
            for(int j = i + 1; j < prices.length; j++){
                if (prices[i] < prices[j])
                    max = Math.max(max, prices[j] - prices[i]);
            }
        return max;
    }


    //只遍历一次
    public int maxProfit01(int[] prices) {
        int res = 0;
        int buy = Integer.MAX_VALUE;
        for(int price : prices){
            buy = Math.min(buy, price);
            res = Math.max(res, price - buy);
        }
        return res;
    }
}
