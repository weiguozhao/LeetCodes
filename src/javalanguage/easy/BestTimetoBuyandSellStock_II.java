package javalanguage.easy;

/**
 * @author zhaoweiguo
 * @date 2019-09-23
 */
public class BestTimetoBuyandSellStock_II {
    /**
     * problem 122
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
     */
    public int maxProfit(int[] prices) {
        return 0;
    }


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
     * */
    public int maxProfile(int[] prices){
        if(prices.length == 0){
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
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            valley = prices[i];

            // 再找峰顶
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]){
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
     * */
    public int maxProfitSimple(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    /**
     * 思路：
     * 1. 暴力法：递归判断所有情况
     * 2. 找到峰顶峰谷，**关键:峰顶峰谷的差的累加和 == 最大收益**
     * 3. 简化Solution2的方法，基本思想是一致的
     * */

    public static void main(String[] args) {

    }
}
