# coding:utf-8

from typing import List


class Solution:
    """
    problem 22
    https://leetcode-cn.com/problems/generate-parentheses/

    给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

    例如，给出 n = 3，生成结果为：
    [
      "((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()"
    ]
    """

    def __init__(self):
        self.left = 0
        self.right = 0
        self.n = 0
        self.res = []

    def generateParenthesis(self, n: int) -> List[str]:
        self.n = n
        self.back_trace("")
        return self.res

    def back_trace(self, s):

        # border or cut
        if self.left > self.n or self.right > self.n or self.left < self.right:
            return

        # root
        if self.left == self.n and self.right == self.n:
            self.res.append(s)
            return

        # left child
        if self.left < self.n:
            self.left += 1
            s += "("
            self.back_trace(s)
            self.left -= 1
            s = s[:-1]

        # right child
        if self.left > self.right:
            self.right += 1
            s += ")"
            self.back_trace(s)
            self.right -= 1
            s = s[: -1]


if __name__ == '__main__':
    res = Solution().generateParenthesis(3)
    for it in res:
        print(it)
