# coding:utf-8

from typing import List


class Solution:
    """
    problem 70
    https://leetcode-cn.com/problems/climbing-stairs/

    假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    注意：给定 n 是一个正整数。

    示例 1：
    输入： 2
    输出： 2
    解释： 有两种方法可以爬到楼顶。
    1.  1 阶 + 1 阶
    2.  2 阶

    示例 2：
    输入： 3
    输出： 3
    解释： 有三种方法可以爬到楼顶。
    1.  1 阶 + 1 阶 + 1 阶
    2.  1 阶 + 2 阶
    3.  2 阶 + 1 阶
    """

    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2

        memo = [0 for _ in range(n + 1)]
        memo[1] = 1
        memo[2] = 2

        for i in range(3, n + 1):
            memo[i] = memo[i - 1] + memo[i - 2]

        return memo[n]

    def climbStairs2(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2

        memo = [0 for _ in range(n + 1)]
        memo[1] = 1
        memo[2] = 2
        self._back_trace_(memo, n)
        return memo[n]

    def _back_trace_(self, memo: List[int], n: int) -> int:
        if memo[n] != 0:
            return memo[n]
        memo[n] = self._back_trace_(memo, n - 1) + self._back_trace_(memo, n - 2)
        return memo[n]


if __name__ == '__main__':
    print(Solution().climbStairs2(3))
