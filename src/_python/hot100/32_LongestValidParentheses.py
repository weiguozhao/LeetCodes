# coding:utf-8


class Solution:
    """
    problem 32
    https://leetcode-cn.com/problems/longest-valid-parentheses/

    给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

    示例 1:
    输入: "(()"
    输出: 2
    解释: 最长有效括号子串为 "()"

    示例 2:
    输入: ")()())"
    输出: 4
    解释: 最长有效括号子串为 "()()"
    """

    def longestValidParentheses(self, s: str) -> int:
        index = 0
        while s[index] == ')':
            index += 1
        s = s[index:]

        length = len(s)
        if length < 1:
            return 0

        # valid_length[i]表示以s[i]结尾的串的最长有效数
        valid_length = [0 for _ in range(length)]
        max_length = 0
        for i in range(1, length):
            if s[i] == '(':
                continue

            # 以 () 结尾的类型
            if s[i - 1] == '(':
                valid_length[i] = valid_length[i - 2] + 2 if i > 2 else 2

            # 以 )) 结尾的类型, 且有效括号之前还有符号 i-valid_length[i - 1]>0
            elif i - valid_length[i - 1] > 0 and s[i - valid_length[i - 1] - 1] == '(':
                # ()(())把类似这种形式的,最前面的()加进来
                value = valid_length[i - valid_length[i - 1] - 2] if (i - valid_length[i - 1]) >= 2 else 0
                valid_length[i] = valid_length[i - 1] + 2 + value

            max_length = max(valid_length[i], max_length)

        return max_length

    def longestValidParenthesesSimple(self, s: str) -> int:
        """
        利用两个计数器 left 和 right。

        首先，从左到右遍历字符串，对于遇到的每个‘(’，增加 left 计算器，否则增加 right 计数器。
        每当 left 计数器与 right 计数器相等时，计算当前有效字符串的长度，并且记录最长匹配串的长度。
        如果 right 计数器比 left 计数器大，将 left 和 right 置零。

        然后从右往左，执行一次类似的操作。如果 left 计数器比 right 计数器大，将 left 和 right 置零。

        原理：整个括号串中，要么只多余左括号，要么只多余右括号，要么多余的右括号必定在多余的左括号的左侧。

        当从左向右遍历时，它相当于按多余的右括号来划分区间，然后统计区间内的匹配子串的长度。
        如果区间内有多余的左括号，则该子串不匹配，并且这个子串一定在整个串的最右侧，多余的左括号一定在子串的最左侧。
        )[匹配长度为 2])))[匹配长度为 4]))...[(((包含多余的左括号的子串]

        当从右向左遍历时，它相当于按多余的左括号来划分区间，然后统计区间内的匹配子串的长度。
        如果区间内有多余的右括号，则该子串不匹配，并且这个子串一定在整个串的最左侧，多余的左括号一定在子串的最右侧。
        [包含多余的右括号的子串))]...((([匹配长度为 8]([匹配长度为 6]((

        这样相当于：将整个字符串，按照“多余的右括号”和“多余的左括号”之间的分界线，分为左右两个子串，
        然后从左到右和从右到左，分别统计两个子串内每个匹配子串的长度。
        """
        left, right, max_length, length = 0, 0, 0, len(s)

        for i in range(length):
            if s[i] == '(':
                left += 1
            else:
                right += 1

            if left == right:
                max_length = max(left + right, max_length)
            elif left <= right:
                left, right = 0, 0

        left, right = 0, 0
        for i in range(length-1, -1, -1):
            if s[i] == '(':
                left += 1
            else:
                right += 1

            if left == right:
                max_length = max(left + right, max_length)
            elif left >= right:
                left, right = 0, 0

        return max_length


if __name__ == '__main__':
    cnt = Solution().longestValidParentheses("()())()")
    print(cnt)
