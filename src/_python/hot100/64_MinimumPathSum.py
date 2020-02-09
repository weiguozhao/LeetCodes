# coding:utf-8

from typing import List


class Solution:
    """
    problem 64
    https://leetcode-cn.com/problems/minimum-path-sum/

    给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    说明：每次只能向下或者向右移动一步。

    示例:
    输入:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    输出: 7
    解释: 因为路径 1→3→1→1→1 的总和最小。
    """

    def minPathSum(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])

        memo = [[0 for _ in range(cols)] for _ in range(rows)]
        memo[rows - 1][cols - 1] = grid[rows - 1][cols - 1]
        for i in range(cols - 2, -1, -1):
            memo[rows - 1][i] = grid[rows - 1][i] + memo[rows - 1][i + 1]
        for i in range(rows - 2, -1, -1):
            memo[i][cols - 1] = grid[i][cols - 1] + memo[i + 1][cols - 1]

        for i in range(rows - 2, -1, -1):
            for j in range(cols - 2, -1, -1):
                memo[i][j] = grid[i][j] + min(memo[i][j + 1], memo[i + 1][j])

        return memo[0][0]

    def minPathSum2(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])

        memo = [[0 for _ in range(cols)] for _ in range(rows)]
        memo[rows - 1][cols - 1] = grid[rows - 1][cols - 1]
        for i in range(cols - 2, -1, -1):
            memo[rows - 1][i] = grid[rows - 1][i] + memo[rows - 1][i + 1]
        for i in range(rows - 2, -1, -1):
            memo[i][cols - 1] = grid[i][cols - 1] + memo[i + 1][cols - 1]

        self.grid = grid
        self.memo = memo
        self.rows = rows
        self.cols = cols
        self._back_trace_(0, 0)
        return self.memo[0][0]

    def _back_trace_(self, row: int, col: int) -> int:
        if self.memo[row][col] != 0:
            return self.memo[row][col]

        right = -1
        if row + 1 < self.rows:
            right = self._back_trace_(row, col + 1)
        down = -1
        if col + 1 < self.cols:
            down = self._back_trace_(row + 1, col)
        min_vale = right if down == -1 or right < down else down
        self.memo[row][col] = self.grid[row][col] + min_vale
        return self.memo[row][col]


if __name__ == '__main__':
    g = [[1, 3, 1],
         [1, 5, 1],
         [4, 2, 1]
         ]
    res = Solution().minPathSum2(g)
    print(res)
