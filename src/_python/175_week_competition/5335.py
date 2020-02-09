# coding:utf-8

from typing import List


class Solution:
    """
    problem 5335
    https://leetcode-cn.com/problems/maximum-students-taking-exam/

    给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。
    学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。
    请你计算并返回该考场可以容纳的一起参加考试且无法作弊的最大学生人数。
    学生必须坐在状况良好的座位上。

    示例 1： https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/09/image.png
    输入：seats = [["#",".","#","#",".","#"],
                  [".","#","#","#","#","."],
                  ["#",".","#","#",".","#"]]
    输出：4
    解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。

    示例 2：
    输入：seats = [[".","#"],
                  ["#","#"],
                  ["#","."],
                  ["#","#"],
                  [".","#"]]
    输出：3
    解释：让所有学生坐在可用的座位上。

    示例 3：
    输入：seats = [["#",".",".",".","#"],
                  [".","#",".","#","."],
                  [".",".","#",".","."],
                  [".","#",".","#","."],
                  ["#",".",".",".","#"]]
    输出：10
    解释：让学生坐在第 1、3 和 5 列的可用座位上。

    提示：
    seats 只包含字符 '.' 和'#'
    m == seats.length
    n == seats[i].length
    1 <= m <= 8
    1 <= n <= 8
    """

    def maxStudentsBackTrace(self, seats: List[List[str]]) -> int:
        """
        回溯法 超时
        """
        self.m, self.n = len(seats), len(seats[0])
        self.seats = seats
        self.ans = 0

        self._back_trace_(0, 0, 0)
        return self.ans

    def _can_seat_(self, row: int, col: int) -> bool:
        if self.seats[row][col] == '#':
            return False
        if col > 0 and self.seats[row][col - 1] == '*':
            return False
        if col < self.n - 1 and self.seats[row][col + 1] == '*':
            return False
        if row > 0 and col > 0 and self.seats[row - 1][col - 1] == '*':
            return False
        if row > 0 and col < self.n - 1 and self.seats[row - 1][col + 1] == '*':
            return False
        return True

    def _back_trace_(self, row: int, col: int, count: int):
        if row >= self.m:
            self.ans = max(self.ans, count)
            return

        for c in range(col, self.n):
            if self._can_seat_(row, c):
                self.seats[row][c] = '*'
                self._back_trace_(row, c + 1, count + 1)
                self.seats[row][c] = '.'

        self._back_trace_(row + 1, 0, count)


if __name__ == '__main__':
    seats = [["#", ".", "#", "#", ".", "#"],
             [".", "#", "#", "#", "#", "."],
             ["#", ".", "#", "#", ".", "#"]]
    res = Solution().maxStudentsBackTrace(seats)
    print(res)
