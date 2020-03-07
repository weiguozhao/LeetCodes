# coding:utf-8

from typing import List


class Solution:
    """
    problem 301
    https://leetcode-cn.com/problems/remove-invalid-parentheses/

    删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
    说明: 输入可能包含了除 ( 和 ) 以外的字符。

    示例 1:
    输入: "()())()"
    输出: ["()()()", "(())()"]

    示例 2:
    输入: "(a)())()"
    输出: ["(a)()()", "(a())()"]

    示例 3:
    输入: ")("
    输出: [""]
    """

    def removeInvalidParentheses(self, s: str) -> List[str]:
        """
        广度优先遍历 + 剪枝
        https://blog.csdn.net/u010005161/article/details/52386001
        """

        def is_valid(seq) -> bool:
            """判断字符串是不是括号匹配的"""
            stack = []
            for ch in seq:
                if ch == '(':
                    stack.append(ch)
                elif ch == ')':
                    if len(stack) != 0 and stack[-1] == '(':
                        del stack[-1]
                    else:
                        return False
            if len(stack) != 0:
                return False
            return True

        queue, found, checked = [s], False, set(s)
        res = []
        while queue:
            candidate = queue.pop(0)
            if is_valid(candidate):
                res.append(candidate)
                found = True
            if found:
                continue

            # queue 中的串都不满足括号匹配
            for i in range(len(candidate)):

                # 非括号部分不会删除
                if candidate[i] != '(' and candidate[i] != ')':
                    continue

                # 删除 candidate[i]
                new_candidate = candidate[:i] + candidate[i + 1:]
                if new_candidate in checked:
                    continue

                checked.add(new_candidate)
                queue.append(new_candidate)

        # 考虑括号全都不成对
        # 删除所有括号，只保留其他字符
        if not res:
            for ch in s:
                if ch != '(' and ch != ')':
                    res.append(ch)
        # 如果res仍空，说明没有其他字符
        return res if res else [""]


if __name__ == '__main__':
    s = "a)"
    ans = Solution().removeInvalidParentheses(s)
    print(ans)
