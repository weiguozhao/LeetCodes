# coding:utf-8

from typing import List


class Solution:
    """
    problem 139
    https://leetcode-cn.com/problems/word-break/

    给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
    说明：
        拆分时可以重复使用字典中的单词。
        你可以假设字典中没有重复的单词。

    示例 1：
    输入: s = "leetcode", wordDict = ["leet", "code"]
    输出: true
    解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

    示例 2：
    输入: s = "applepenapple", wordDict = ["apple", "pen"]
    输出: true
    解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
         注意你可以重复使用字典中的单词。

    示例 3：
    输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
    输出: false
    """

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.memo: List[bool] = [None for _ in range(len(s) + 1)]
        self.word_dict = set(wordDict)
        return self._word_break_memo_(s, 0)

    def _word_break_brute_force_(self, s: str, index: int) -> bool:
        """
        暴力回溯
        time:O(n^n)
        space: O(n) 保存set类型的word_dict
        """
        if index == len(s):
            return True
        for i in range(index + 1, len(s) + 1):
            if s[index:i] in self.word_dict and self._word_break_brute_force_(s, i):
                return True
        return False

    def _word_break_memo_(self, s: str, start: int) -> bool:
        """
        time: O(n^2)
        space: O(n)
        memo[start]表示从start开始的后缀串是否满足题意
        """
        if start == len(s):
            return True

        if self.memo[start] is not None:
            return self.memo[start]
        for end in range(start + 1, len(s) + 1):
            if s[start:end] in self.word_dict and self._word_break_memo_(s, end):
                self.memo[start] = True
                return self.memo[start]

        self.memo[start] = False
        return self.memo[start]

    def _bfs_(self, s: str):
        """
        每个节点表示从s中拆出的前缀word
        time: O(n^2)
        space: O(n)

        详细示例见方法3：
        https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode/
        """
        queue = []
        visited = [False] * len(s)
        # 0表示为end的前缀串(也可以理解为下次的start位置)
        queue.append(0)
        while queue:
            start = queue.pop()
            if not visited[start]:
                for end in range(start + 1, len(s) + 1):
                    if s[start:end] in self.word_dict:
                        queue.append(end)
                        if end == len(s):
                            return True
                visited[start] = True
        return False

    def _dynamic_program_(self, s: str):
        """
        memo[i]表示以index=i结束的串是否满足题意
        """
        # 空字符串
        self.memo[0] = True
        for i in range(len(self.memo)):
            self.memo[i] = False

        for i in range(1, len(s) + 1):
            for j in range(0, i):
                # s[0:i]被分成了 s[0:j]和 s[j:i]两部分
                if self.memo[j] and s[j:i] in self.word_dict:
                    self.memo[i] = True
                    break

        return self.memo[len(s)]


if __name__ == '__main__':
    s = "catsandog"
    wordDict = ["cats", "dog", "sand", "and", "cat"]
    res = Solution().wordBreak(s, wordDict)
    print(res)
