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


if __name__ == '__main__':
    s = "cbbd"
    res = Solution().longestPalindrome(s)
    print(res)
