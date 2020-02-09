# coding:utf-8

class Solution:
    """
    problem 62
    https://leetcode-cn.com/problems/unique-paths/

    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    问总共有多少条不同的路径？

    https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png
    例如，上图是一个7 x 3 的网格。有多少可能的路径？
    说明：m 和 n 的值均不超过 100。

    示例 1:
    输入: m = 3, n = 2
    输出: 3
    解释:
    从左上角开始，总共有 3 条路径可以到达右下角。
    1. 向右 -> 向右 -> 向下
    2. 向右 -> 向下 -> 向右
    3. 向下 -> 向右 -> 向右

    示例 2:
    输入: m = 7, n = 3
    输出: 28
    """

    def uniquePaths(self, m: int, n: int) -> int:
        """
        自底向上动态规划
        """
        memo = [[0] * n] * m

        for i in range(n):
            memo[m - 1][i] = 1
        for i in range(m):
            memo[i][n - 1] = 1

        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                memo[i][j] = memo[i][j + 1] + memo[i + 1][j]

        return memo[0][0]

    def uniquePaths2(self, m: int, n: int) -> int:
        """
        自顶向下动态规划
        """
        self.m = m
        self.n = n
        self.memo = [[0 for _ in range(n)] for _ in range(m)]

        for i in range(n):
            self.memo[m - 1][i] = 1
        for i in range(m):
            self.memo[i][n - 1] = 1

        return self._back_trace_(0, 0)

    def _back_trace_(self, row: int, col: int) -> int:
        if self.memo[row][col] != 0:
            return self.memo[row][col]

        right = 0
        if col + 1 < self.n:
            right = self._back_trace_(row, col + 1)
        down = 0
        if row + 1 < self.m:
            down = self._back_trace_(row + 1, col)

        self.memo[row][col] = right + down
        return self.memo[row][col]


if __name__ == '__main__':
    m, n = 7, 3
    res = Solution().uniquePaths2(m, n)
    print(res)
