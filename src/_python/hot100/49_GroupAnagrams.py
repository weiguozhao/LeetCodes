# coding:utf-8

from typing import List


class Solution:
    """
    problem 49
    https://leetcode-cn.com/problems/group-anagrams/

    给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

    示例:
    输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
    输出:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]

    说明：
    所有输入均为小写字母。
    不考虑答案输出的顺序。
    """

    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = {}
        for s in strs:
            value = "".join(sorted(s))
            if value not in res.keys():
                res[value] = []
            res[value].append(s)
        return [x for x in res.values()]

    def groupAnagramsCount(self, strs: List[str]) -> List[List[str]]:
        res = {}
        for s in strs:
            count = [0] * 26
            for i in s:
                count[ord(i) - ord('a')] += 1

            key = tuple(count)
            if key not in res.keys():
                res[key] = []
            res[key].append(s)
        return [x for x in res.values()]


if __name__ == '__main__':
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    res = Solution().groupAnagramsCount(strs)
    for it in res:
        print(it)
