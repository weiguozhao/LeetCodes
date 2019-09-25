package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-23
 */
public class BestTimetoBuyandSellStock {
    /**
     * problem 121
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int result = 0, minPrices = prices[0];
        for (int x : prices) {
            result = x - minPrices > result ? x - minPrices : result;
            minPrices = x > minPrices ? minPrices : x;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int profile = new BestTimetoBuyandSellStock().maxProfit(prices);
        System.out.println(profile);
    }
}
