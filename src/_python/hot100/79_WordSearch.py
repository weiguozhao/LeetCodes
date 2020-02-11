# coding:utf-8

from typing import List


class Solution:
    """
    problem 79
    https://leetcode-cn.com/problems/word-search/

    给定一个二维网格和一个单词，找出该单词是否存在于网格中。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    同一个单元格内的字母不允许被重复使用。

    示例:
    board =
    [
      ['A','B','C','E'],
      ['S','F','C','S'],
      ['A','D','E','E']
    ]

    给定 word = "ABCCED", 返回 true.
    给定 word = "SEE", 返回 true.
    给定 word = "ABCB", 返回 false.
    """

    def exist(self, board: List[List[str]], word: str) -> bool:
        self.board = board
        self.rows = len(board)
        if self.rows == 0:
            return False
        self.cols = len(board[0])
        self.direct = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        self.is_visited = [[False for _ in range(self.cols)] for _ in range(self.rows)]
        self.word = word
        self.wlength = len(word)

        for i in range(self.rows):
            for j in range(self.cols):
                if self._back_trace_(i, j, 0):
                    return True
        return False

    def _back_trace_(self, row: int, col: int, index: int) -> bool:
        if index == self.wlength - 1:
            return self.board[row][col] == self.word[index]

        if self.board[row][col] == self.word[index]:
            self.is_visited[row][col] = True
            for d in self.direct:
                new_row = row + d[0]
                new_col = col + d[1]
                if 0 <= new_row < self.rows and 0 <= new_col < self.cols \
                        and self._back_trace_(new_row, new_col, index + 1):
                    return True
            self.is_visited[row][col] = False

        return False


if __name__ == '__main__':
    b = [['A', 'B', 'C', 'E'],
         ['S', 'F', 'C', 'S'],
         ['A', 'D', 'E', 'E']
         ]
    w = "ABCCED"
    res = Solution().exist(b, w)
    print(res)
