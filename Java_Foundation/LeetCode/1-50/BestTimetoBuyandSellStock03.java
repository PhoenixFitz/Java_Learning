package stage.one.klaus;
/**
 *Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * http://www.cnblogs.com/grandyang/p/4281975.html （动态规划）
 */

public class BestTimetoBuyandSellStock03 {
    public static void main(String[] args){
        int[] nums = {3,3,5,0,0,3,1,4};

        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        // At first we have 0 money in hand
        int maxMoneyInHandBeforeBuyFirstTime = Integer.MIN_VALUE;
        int maxMoneyInHandAfterSellFirstTime = 0;
        int maxMoneyInHandBeforeBuySecondTime = Integer.MIN_VALUE;
        int maxMoneyInHandAfterSellSecondTime = 0;
        for (int i = 0; i < prices.length; i++) {
            // we have 0 money in hand before buy first time. if we buy at prices[i], it cost us prices[i], leading to
            // the fact that the money in our hands is  (0 - prices[i])
            maxMoneyInHandBeforeBuyFirstTime = Math.max(maxMoneyInHandBeforeBuyFirstTime, 0 - prices[i]);
            maxMoneyInHandAfterSellFirstTime = Math.max(maxMoneyInHandAfterSellFirstTime,
                    maxMoneyInHandBeforeBuyFirstTime + prices[i]);
            maxMoneyInHandBeforeBuySecondTime = Math.max(maxMoneyInHandBeforeBuySecondTime,
                    maxMoneyInHandAfterSellFirstTime - prices[i]);
            maxMoneyInHandAfterSellSecondTime = Math.max(maxMoneyInHandAfterSellSecondTime,
                    maxMoneyInHandBeforeBuySecondTime + prices[i]);
        }

        return maxMoneyInHandAfterSellSecondTime;
    }


    //动态规划
    public int maxProfit02(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int[] local = new int[3];
        int[] global = new int[3];
        for(int i=0;i<prices.length-1;i++)
        {
            int diff = prices[i+1]-prices[i];
            for(int j=2;j>=1;j--)
            {
                local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[2];
    }

}
