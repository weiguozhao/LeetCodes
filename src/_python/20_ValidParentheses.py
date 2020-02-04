# coding:utf-8


class Solution:
    """
    problem 20
    https://leetcode-cn.com/problems/valid-parentheses/

    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
    有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。

    示例 1:
    输入: "()"
    输出: true

    示例 2:
    输入: "()[]{}"
    输出: true

    示例 3:
    输入: "(]"
    输出: false

    示例 4:
    输入: "([)]"
    输出: false

    示例 5:
    输入: "{[]}"
    输出: true
    """

    def __init__(self):
        self.valid = {')': '(',
                      '}': '{',
                      ']': '['}

    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch in self.valid.keys():
                # right part
                cmp = self.valid[ch]
                if len(stack) < 1 or cmp != stack.pop():
                    return False
            else:
                # left part
                stack.append(ch)

        return len(stack) == 0


if __name__ == '__main__':
    s = "([)]"
    res = Solution().isValid(s)
    print(res)
