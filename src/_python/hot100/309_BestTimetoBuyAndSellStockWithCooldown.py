# coding:utf-8

from typing import List


class Solution:
    """
    problem 309
    https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

    给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
    设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

    你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

    示例:
    输入: [1,2,3,0,2]
    输出: 3
    解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
    """

    def maxProfit(self, prices: List[int]) -> int:
        """
        memo[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益
        j 的候选状态有：不持股且能购买(0)；持股(1)；不持股且不能购买(2)
        买股票 -> -prices[i]； 卖股票 -> +prices[i]
        """
        length = len(prices)
        if length < 2:
            return 0

        memo = [[0 for _ in range(3)] for _ in range(length)]
        memo[0][0] = 0
        memo[0][1] = -prices[0]  # 买第0天的股票
        memo[0][2] = 0

        for i in range(1, length):
            # 今天不持股且能购买 <=> 昨天没买/昨天刚卖，今天也不买
            memo[i][0] = max(memo[i - 1][0], memo[i - 1][2])
            # 今天持股 <=> 昨天持股 / 今天买入
            memo[i][1] = max(memo[i - 1][1], memo[i - 1][0] - prices[i])
            # 今天不持股且不能购买 <=> 今天卖出
            memo[i][2] = memo[i - 1][1] + prices[i]

        return max(memo[length - 1][0], memo[length - 1][2])


if __name__ == '__main__':
    prices = [1, 2, 3, 0, 2]
    ans = Solution().maxProfit(prices)
    print(ans)
