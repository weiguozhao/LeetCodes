# coding:utf-8


class Solution:
    """
    problem 5: 长回文子串
    https://leetcode-cn.com/problems/longest-palindromic-substring/

    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

    示例 1：
    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。

    示例 2：
    输入: "cbbd"
    输出: "bb"
    """

    def longestPalindrome(self, s: str) -> str:
        length = len(s)
        if length <= 1:
            return s

        longest_palindrome = ""
        for i in range(length):
            sub_len = 0
            # 奇数个字符为回文串
            while i - sub_len >= 0 and i + sub_len < length and s[i - sub_len] == s[i + sub_len]:
                sub_len += 1

            sub_len -= 1
            if len(longest_palindrome) < 2 * sub_len + 1:
                longest_palindrome = s[i - sub_len: i + sub_len + 1]

            # 偶数个字符为回文串
            if i + 1 < length and s[i] == s[i + 1]:
                sub_len = 0
                while i - sub_len >= 0 and i + sub_len + 1 < length and s[i - sub_len] == s[i + i + sub_len]:
                    sub_len += 1
                sub_len -= 1
                if len(longest_palindrome) < 2 * (sub_len + 1):
                    longest_palindrome = s[i - sub_len: i + sub_len + 2]

        return longest_palindrome

    def longestPalindromeDynamicProgram(self, s: str) -> str:
        """
        time： O(n^2)
        space: O(n^2)
        :param s:
        :return:
        """
        length = len(s)
        if length <= 1:
            return s

        longest_palindrome = s[0]
        is_palindrome = [[False for _ in range(length)] for _ in range(length)]
        for i in range(length):
            is_palindrome[i][i] = True
            if i > 0 and s[i - 1] == s[i]:
                is_palindrome[i - 1][i] = True
                longest_palindrome = s[i - 1: i + 1]

        for i in range(length - 1, -1, -1):
            for j in range(i + 1, length):
                if s[i] == s[j] and is_palindrome[i + 1][j - 1]:
                    is_palindrome[i][j] = True
                    if len(longest_palindrome) < j - i + 1:
                        longest_palindrome = s[i: j + 1]

        return longest_palindrome

    def longestPalindromeDynamicProgramOptimizeSpace(self, s: str) -> str:
        """
        time： O(n^2)
        space: O(n)
        :param s:
        :return:
        """
        length = len(s)
        longest_palindrome = ""
        is_palindrome = [False for _ in range(length)]

        # is_palindrome[j] = is_palindrome[j-1] and s[i] == s[j]
        # 第i行的结果只有第i+1行的结果决定
        for i in range(length - 1, -1, -1):
            for j in range(length - 1, i - 1, -1):
                # 将单个字符、两个字符相等的情况放到这里一起判断
                is_palindrome[j] = s[i] == s[j] and (j - i < 3 or is_palindrome[j - 1])
                if len(longest_palindrome) < j - i + 1:
                    longest_palindrome = s[i: j + 1]

        return longest_palindrome


if __name__ == '__main__':
    s = "abcda"
    res1 = Solution().longestPalindrome(s)
    res2 = Solution().longestPalindromeDynamicProgram(s)
    print(res1, res2)
