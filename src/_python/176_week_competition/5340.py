# coding:utf-8

from typing import List


class Solution:
    """
    给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
    请你统计并返回 grid 中 负数 的数目。

    示例 1：
    输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
    输出：8
    解释：矩阵中共有 8 个负数。

    示例 2：
    输入：grid = [[3,2],[1,0]]
    输出：0

    示例 3：
    输入：grid = [[1,-1],[-1,-1]]
    输出：3

    示例 4：
    输入：grid = [[-1]]
    输出：1
    """

    def countNegatives(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        ans = 0

        for row in range(m - 1, -1, -1):
            if grid[row][n - 1] >= 0:
                continue
            for col in range(n - 1, -1, -1):
                if grid[row][col] < 0:
                    ans += 1
                else:
                    break

        return ans


if __name__ == '__main__':
    grid = [[3,2],[1,0]]
    res = Solution().countNegatives(grid)
    print(res)
