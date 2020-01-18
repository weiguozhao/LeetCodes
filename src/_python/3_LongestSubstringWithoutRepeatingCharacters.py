# coding:utf-8


class Solution:
    """
    problem 3: 无重复字符的最长子串
    https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

    给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:
    输入: "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

    示例 2:
    输入: "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

    示例 3:
    输入: "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    """

    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        time: O(n)
        space: O(n)
        :param s:
        :return:
        """

        # charters保存的是遇到此字符后重新的起始位置
        # 优化思路：根据字符的范围，可以直接用一个int的数组模拟 dict
        charters = {}
        start_index, end_index, max_count = 0, 0, 0
        for ch in s:
            if ch in charters:
                start_index = max(charters[ch], start_index)
            charters[ch] = end_index + 1
            end_index += 1
            max_count = max(max_count, end_index - start_index)

        return max_count


if __name__ == '__main__':
    s = "bbbb"

    solution = Solution()
    res = solution.lengthOfLongestSubstring(s)
    print(res)
    pass
