# coding:utf-8

from typing import List


class Solution:
    """
    problem 240
    https://leetcode-cn.com/problems/search-a-2d-matrix-ii/

    编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
        每行的元素从左到右升序排列。
        每列的元素从上到下升序排列。

    示例:
    现有矩阵 matrix 如下：
        [
          [1,   4,  7, 11, 15],
          [2,   5,  8, 12, 19],
          [3,   6,  9, 16, 22],
          [10, 13, 14, 17, 24],
          [18, 21, 23, 26, 30]
        ]

    给定 target = 5，返回 true。
    给定 target = 20，返回 false。
    """

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False

        m, n = len(matrix), len(matrix[0])
        row, col = 0, n - 1
        while matrix[row][col] != target:
            if matrix[row][col] < target:
                row += 1
            elif matrix[row][col] > target:
                col -= 1

            if row >= m or col < 0:
                return False

        return True


if __name__ == '__main__':
    matrix = [
        [1, 4, 7, 11, 15],
        [2, 5, 8, 12, 19],
        [3, 6, 9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
    ]
    target = 20
    res = Solution().searchMatrix(matrix, target)
    print(res)
