package _java.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-23
 */
public class BestTimetoBuyandSellStock_II {
    /**
     * problem 122
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     *
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     *
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */


    /**
     * 暴力法 - 超时
     * time: O(n^n)
     * space: O(n)
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
     */
    public int maxProfitDirect(int[] prices) {
        return maxProfile(prices, 0);
    }

    private int maxProfile(int[] prices, int depth) {
        if (depth >= prices.length) {
            return 0;
        }

        int max = 0;
        for (int start = depth; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = maxProfile(prices, i + 1) + prices[i] - prices[start];
                    maxprofit = profit > maxprofit ? profit : maxprofit;
                }
            }
            max = maxprofit > max ? maxprofit : max;
        }
        return max;
    }

    /**
     * 峰顶峰谷法
     * time: O(n)
     * space: O(1)
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int i = 0;
        // 峰谷
        int valley = prices[0];
        // 峰顶
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            // 先找峰谷
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];

            // 再找峰顶
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];

            // 当前收益累加上去
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    /**
     * 思路同Solution 2相似
     * 如果price[i] > price[i-1]，即后面的价格高于前面的，就发生交易
     */
    public int maxProfitSimple(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

    /**
     * 思路：
     * 1. 暴力法：递归判断所有情况
     * 2. 找到峰顶峰谷，**关键:峰顶峰谷的差的累加和 == 最大收益**
     * 3. 简化Solution2的方法，基本思想是一致的
     */
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = new BestTimetoBuyandSellStock_II().maxProfit(prices);
        System.out.println(res);
    }
}
