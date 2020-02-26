# coding:utf-8

from typing import List


class Solution:
    """
    problem 221
    https://leetcode-cn.com/problems/maximal-square/

    在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

    示例:
        输入:
        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0
        输出: 4
    """

    def maximalSquare(self, matrix: List[List[str]]) -> int:
        rows, cols = len(matrix), len(matrix[0])

        # memo[i][j] 表示以 matrix[i][j] 为左上角的正方形的最大边长
        memo = [[0 for _ in range(cols + 1)] for _ in range(rows + 1)]
        max_sqlen = 0
        for i in range(1, rows + 1):
            for j in range(1, cols + 1):
                # 左斜上方为1
                if matrix[i - 1][j - 1] == '1':
                    memo[i][j] = min(memo[i][j - 1], memo[i - 1][j], memo[i - 1][j - 1]) + 1
                    max_sqlen = max(max_sqlen, memo[i][j])

        return max_sqlen * max_sqlen


if __name__ == '__main__':
    pass
