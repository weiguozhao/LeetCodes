# coding:utf-8

from collections import Counter


class Solution:
    """
    problem 76
    https://leetcode-cn.com/problems/minimum-window-substring/

    给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

    示例：
    输入: S = "ADOBECODEBANC", T = "ABC"
    输出: "BANC"

    说明：
    如果 S 中不存这样的子串，则返回空字符串 ""。
    如果 S 中存在这样的子串，我们保证它是唯一的答案。
    """

    def minWindow(self, s: str, t: str) -> str:
        if not s or not t:
            return ""

        # Dictionary which keeps a count of all the unique characters in t.
        dict_t = Counter(t)
        required = len(dict_t)
        # formed is used to keep track of how many unique characters in t are present
        # in the current window in its desired frequency.
        # e.g. if t is "AABC" then the window must have two A's, one B and one C.
        # Thus formed would be = 3 when all these conditions are met.
        formed, left, right = 0, 0, 0
        window_counts = {}
        # (window length, left, right)
        ans = float('inf'), None, None

        while right < len(s):

            character = s[right]
            window_counts[character] = window_counts.get(character, 0) + 1

            if character in dict_t and window_counts[character] == dict_t[character]:
                formed += 1

            # 到达可行窗口
            while left <= right and formed == required:
                character = s[left]

                if right - left + 1 < ans[0]:
                    ans = right - left + 1, left, right

                window_counts[character] -= 1
                # 减少了一个character后不再是可行窗口
                if character in dict_t and window_counts[character] < dict_t[character]:
                    formed -= 1

                left += 1

            right += 1

        return "" if ans[0] == float("inf") else s[ans[1]: ans[2] + 1]


if __name__ == '__main__':
    S = "ADOBECODEBANC"
    T = "ABC"
    res = Solution().minWindow(S, T)
    print(res)
