# coding:utf-8

from typing import List


class Solution:
    """
    https://leetcode-cn.com/contest/weekly-contest-180/problems/lucky-numbers-in-a-matrix/

    给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
    幸运数是指矩阵中满足同时下列两个条件的元素：
        在同一行的所有元素中最小
        在同一列的所有元素中最大

    示例 1：
    输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
    输出：[15]
    解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。

    示例 2：
    输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
    输出：[12]
    解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。

    示例 3：
    输入：matrix = [[7,8],[1,2]]
    输出：[7]

    提示：
    m == mat.length
    n == mat[i].length
    1 <= n, m <= 50
    1 <= matrix[i][j] <= 10^5
    矩阵中的所有元素都是不同的
    """

    def luckyNumbers(self, matrix: List[List[int]]) -> List[int]:
        rows, cols = len(matrix), len(matrix[0])

        row_min = set()
        for i in range(rows):
            temp = matrix[i][0]
            for j in range(1, cols):
                if matrix[i][j] < temp:
                    temp = matrix[i][j]
            row_min.add(temp)

        col_max = set()
        for j in range(cols):
            temp = matrix[0][j]
            for i in range(1, rows):
                if matrix[i][j] > temp:
                    temp = matrix[i][j]
            col_max.add(temp)

        lucy_num = row_min.intersection(col_max)
        return list(lucy_num)


if __name__ == '__main__':
    matrix = [[7, 8],
              [1, 2]]
    ans = Solution().luckyNumbers(matrix)
    print(ans)
