# coding:utf-8


class Solution:
    """
    problem 279
    https://leetcode-cn.com/problems/perfect-squares/

    给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
    你需要让组成和的完全平方数的个数最少。

    示例 1:
    输入: n = 12
    输出: 3
    解释: 12 = 4 + 4 + 4.

    示例 2:
    输入: n = 13
    输出: 2
    解释: 13 = 4 + 9.
    """

    def numSquares(self, n: int) -> int:
        # 初始化每个值由n个1组成，最坏情况
        memo = [i for i in range(n + 1)]

        for i in range(1, n + 1):
            # 不断去尝试减去一个平方数 j * j
            j = 1
            while i - j * j >= 0:
                memo[i] = min(memo[i], memo[i - j * j] + 1)
                j += 1

        return memo[n]


if __name__ == '__main__':
    res = Solution().numSquares(13)
    print(res)
